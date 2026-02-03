# Rust Notes

## 1) Definición y características

* **Rust** es un lenguaje compilado que busca **seguridad de memoria** y
  **concurrencia segura** sin garbage collector, manteniendo performance.
* Su “particularidad” vs otros lenguajes: **ownership/borrowing** como regla
  central del diseño (cómo se mueve o presta la memoria).

## 2) Documentación oficial (las 4 “biblias”)

* **The Rust Programming Language (The Book)**: el camino principal. ([doc.rust-lang.org][1])
* **std docs**: API de la librería estándar (búsqueda por tipos/métodos).
* **Rust Reference**: especificación (cuando quieres precisión).
* **Cargo Book**: comandos y flujo de build/test/publish. ([doc.rust-lang.org][3])

(Además: **Edition Guide** cuando algo cambia por edición, p. ej. módulos). ([doc.rust-lang.org][4])

## 3) Estructura básica de un archivo `.rs`

* `use ...;` importa nombres (tipos, traits, funciones, macros).
* `struct`, `enum`: tus tipos.
* `fn ... {}`: funciones.
* `impl Type { ... }`: métodos.
* `#[...]`: *attributes* (metadata para el compilador o macros).
* `println!`, `writeln!`: **macros** (nota el `!`).

## 4) Estructura típica de un proyecto (Cargo)

* `Cargo.toml`: manifiesto (nombre, versión, edición, dependencias).
* `src/main.rs`: binario (tiene `fn main()`).
* `src/lib.rs`: librería (cuando el crate expone API reusable).
* `src/bin/*.rs`: múltiples binarios (opcional).
* `tests/`, `examples/`, `benches/`: carpetas típicas.

La idea clave: *crate root* suele ser `main.rs` (bin) o `lib.rs` (lib).
(Esto se relaciona con cómo se resuelven módulos/paths por edición). ([doc.rust-lang.org][4])

## 5) “Ciclo de vida” mínimo (compilar / correr / compartir)

* Crear proyecto: `cargo new <nombre>`
* Compilar: `cargo build`
* Compilar + ejecutar: `cargo run`
* Chequeo rápido (sin generar binario final): `cargo check`
* Tests: `cargo test` ([doc.rust-lang.org][3])
* Docs: `cargo doc --open`
* Publicar en registry (crates.io por defecto): `cargo publish` ([doc.rust-lang.org][5])

Herramientas comunes (instalables como componentes): `cargo fmt` (rustfmt). ([docs.adacore.com][6])

## 6) Tipos de datos: lo imprescindible

* Escalares: `i32/u32/...`, `f32/f64`, `bool`, `char` (Unicode).
* Compuestos: tuplas `(T1, T2)`, arrays `[T; N]`.
* Strings (importantísimo):

  * `String`: **dueño** de memoria (heap), crece.
  * `&str`: **vista prestada** (slice) sobre texto (muy común en args).
  * Este tema se entiende bien con ownership/borrowing. ([doc.rust-lang.org][2])

## 7) Cómo se “pasan datos” a funciones (la regla mental)

Piensa en 3 modos:

1. **Move** (entregas ownership): `fn f(s: String)`

   * El que llama *pierde* ese `String` (a menos que lo devuelvas).

2. **Borrow inmutable**: `fn f(s: &String)` o (mejor) `fn f(s: &str)`

   * El que llama mantiene ownership. Es el patrón más común.

3. **Borrow mutable**: `fn f(s: &mut String)`

   * Permite modificar, pero con reglas estrictas.

La motivación y el “por qué” está en ownership + references/borrowing. ([doc.rust-lang.org][2])

---

## 8) “Pasar por valor” en Rust: Copy vs Move (ownership)

En Rust, pasar un parámetro “por valor” (`T`) no significa siempre “copiar
bits”. Puede significar:

### A) **Copy** (se copia, el original sigue usable)

Tipos simples suelen ser `Copy` (enteros, bool, etc.).

```rust
fn inc(x: u32) -> u32 { x + 1 }

let a = 10u32;
let b = inc(a);
println!("{a} {b}"); // OK: u32 es Copy
```

### B) **Move** (se transfiere propiedad, el original queda inválido)

Tipos que administran heap (como `String`, `Vec`) normalmente NO son `Copy`.

```rust
fn consume(s: String) {
    println!("{s}");
}

let name = String::from("Rust");
consume(name);
// println!("{name}"); // ERROR: se movió (move) a la función
```

Este modelo (“ownership”) permite seguridad de memoria sin GC. ([doc.rust-lang.org][5])

---

## 9) Referencias: `&T`, `&mut T`, y el sentido de `&` y `*`

### `&T` (borrow inmutable)

Una referencia permite **usar un valor sin tomar propiedad**. ([doc.rust-lang.org][6])

```rust
fn len(s: &String) -> usize { s.len() }

let s = String::from("hola");
let n = len(&s);
println!("{s} {n}"); // OK: no se movió
```

### `&mut T` (borrow mutable)

Permite modificar el valor **sin moverlo**, con reglas de exclusividad del
borrow checker. ([doc.rust-lang.org][6])

```rust
fn push_x(s: &mut String) {
    s.push('x');
}

let mut s = String::from("a");
push_x(&mut s);
println!("{s}"); // "ax"
```

### `&` y `*` no son “punteros C” (aunque se parecen)

* `&` crea una referencia (`&T` o `&mut T`).
* `*` **desreferencia** (accede al valor detrás de una referencia).

Ejemplo de `*`:

```rust
let x = 5;
let r = &x;
println!("{}", *r); // 5
```

La diferencia clave con C: estas referencias están controladas por el
compilador para evitar aliasing/mutación inválida en código seguro. ([doc.rust-lang.org][6])

---

## 3) CLI en Rust con `clap` (derive): idea, forma y ejemplo mínimo

`clap` permite definir una CLI declarativamente con `struct`/`enum` y
atributos (`#[...]`), generando el parser automáticamente. ([Docs.rs][7])

### Ejemplo mínimo: subcomandos con `derive`

```rust
use clap::{Parser, Subcommand};

#[derive(Parser)]
#[command(name = "app", about = "Ejemplo CLI")]
struct Cli {
    #[command(subcommand)]
    cmd: Cmd,
}

#[derive(Subcommand)]
enum Cmd {
    Add { task: String },
    List,
}

fn main() {
    let cli = Cli::parse();
    match cli.cmd {
        Cmd::Add { task } => println!("add: {task}"),
        Cmd::List => println!("list"),
    }
}
```

Puntos fundamentales:

* `#[derive(Parser)]` habilita `Cli::parse()` (lo genera `clap`). ([Docs.rs][7])
* `#[command(subcommand)]` indica que el campo es un conjunto de subcomandos
  (normalmente un `enum`). ([Docs.rs][8])

---

## 4) I/O de archivos: `OpenOptions`, `Write`, `Read`, `writeln!`

### Abrir/crear para **append**

`OpenOptions` controla flags como `create`, `append`, `read`, `write`,
`truncate`, etc. ([doc.rust-lang.org][9])

```rust
use std::fs::OpenOptions;
use std::io::Write;

fn append_line(path: &str, line: &str) -> std::io::Result<()> {
    let mut f = OpenOptions::new()
        .create(true)
        .append(true)
        .open(path)?;

    writeln!(f, "{line}")?;
    Ok(())
}
```

`writeln!` escribe texto formateado a un buffer, agregando `\n`. ([doc.rust-lang.org][10])

### Reescribir desde cero: `truncate(true)`

`truncate(true)` deja el archivo en longitud 0 si existe (requiere `write`).
([doc.rust-lang.org][9])

```rust
use std::fs::OpenOptions;
use std::io::Write;

fn overwrite(path: &str, content: &str) -> std::io::Result<()> {
    let mut f = OpenOptions::new()
        .write(true)
        .truncate(true)
        .open(path)?;

    f.write_all(content.as_bytes())?;
    Ok(())
}
```

---

## 5) Lectura por líneas: `BufReader` + trait `BufRead` + `lines()`

Leer “línea por línea” sin buffer puede ser ineficiente; por eso existe
`BufRead`, que agrega métodos como `read_line` y el iterador `lines()`. ([doc.rust-lang.org][11])

Ejemplo:

```rust
use std::fs::File;
use std::io::{self, BufRead, BufReader};

fn print_lines(path: &str) -> io::Result<()> {
    let file = File::open(path)?;
    let reader = BufReader::new(file);

    for line in reader.lines() {
        let line = line?;      // cada línea puede fallar → Result
        println!("{line}");
    }
    Ok(())
}
```

`lines()` retorna un iterador de líneas sobre un `BufRead`. ([doc.rust-lang.org][12])

---

## 6) Iteradores: `enumerate`, `filter`, `map`, `collect`

Rust usa mucho pipelines de iteradores: se encadenan adaptadores y al final se
“consume” el iterador (por ejemplo con `collect()` o un `for`).

### `enumerate()`

`enumerate()` produce `(índice, elemento)` mientras se itera. ([doc.rust-lang.org][13])

Ejemplo: filtrar una línea por número (1-based) y recolectar:

```rust
fn remove_line(lines: Vec<String>, remove_1based: usize) -> Vec<String> {
    lines.into_iter()
        .enumerate() // (0, line), (1, line)...
        .filter(|(i, _)| i + 1 != remove_1based)
        .map(|(_, line)| line)
        .collect()
}
```

Idea clave:

* `into_iter()` aquí **mueve** el `Vec<String>` y sus strings (ownership), lo
  que evita copias.
* `collect()` materializa el resultado en una colección (aquí `Vec<String>`).

---

## 7) Extra fundamental (muy recomendado): `Result` + `?` en vez de `unwrap()`

Muchas APIs de I/O devuelven `Result`. En notas de Rust, esto suele ser “core
Rust” porque se usa en todo.

Patrón base:

```rust
use std::io;

fn do_work() -> io::Result<()> {
    // ... operaciones que retornan Result
    Ok(())
}
```

Y el operador `?`:

* Si todo va bien, extrae el valor.
* Si hay error, retorna inmediatamente ese error.

(Este patrón aparece en los ejemplos anteriores de I/O y lectura de líneas.)

---

Si se quiere continuar con las “Rust Notes” en la misma línea, el siguiente
bloque lógico suele ser: **módulos (`mod`), `use`, visibilidad (`pub`) y
estructura de proyecto** (cómo se divide `main.rs`/`lib.rs`/`mod.rs` por
edición).

[1]: https://doc.rust-lang.org/cargo/commands/cargo-doc.html?utm_source=chatgpt.com "cargo doc - The Cargo Book"
[2]: https://doc.rust-lang.org/cargo/commands/cargo-publish.html?utm_source=chatgpt.com "cargo publish - The Cargo Book"
[3]: https://doc.rust-lang.org/cargo/reference/publishing.html?utm_source=chatgpt.com "Publishing on crates.io - The Cargo Book"
[4]: https://doc.rust-lang.org/cargo/?utm_source=chatgpt.com "Introduction - The Cargo Book"
[5]: https://doc.rust-lang.org/book/ch04-00-understanding-ownership.html?utm_source=chatgpt.com "Understanding Ownership"
[6]: https://doc.rust-lang.org/book/ch04-02-references-and-borrowing.html?utm_source=chatgpt.com "References and Borrowing - The Rust Programming ..."
[7]: https://docs.rs/clap/latest/clap/_derive/_tutorial/index.html?utm_source=chatgpt.com "clap::_derive::_tutorial - Rust"
[8]: https://docs.rs/clap/latest/clap/_derive/index.html?utm_source=chatgpt.com "clap::_derive - Rust"
[9]: https://doc.rust-lang.org/std/fs/struct.OpenOptions.html?utm_source=chatgpt.com "OpenOptions in std::fs"
[10]: https://doc.rust-lang.org/std/macro.writeln.html?utm_source=chatgpt.com "Macro - writeln in std"
[11]: https://doc.rust-lang.org/std/io/trait.BufRead.html?utm_source=chatgpt.com "BufRead in std::io - Rust"
[12]: https://doc.rust-lang.org/std/io/struct.Lines.html?utm_source=chatgpt.com "Lines in std::io"
[13]: https://doc.rust-lang.org/std/iter/struct.Enumerate.html?utm_source=chatgpt.com "Enumerate in std::iter"
