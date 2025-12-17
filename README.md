# 🐾 Refugio de Animales — Java Console 🐶😺

Sistema en consola para administrar un **Refugio de Animales**, pensado para uso simple por voluntarios.  
Permite registrar **especies**, registrar **animales**, marcar **adopciones**, listar por estado y generar un **reporte general**.

Este proyecto fue desarrollado como **Challenger Integrador**, enfocado en practicar:
- Colecciones (`List`, `Set`, `Map`)
- Validación de entradas
- Menú con `do-while`
- Métodos `static` (sin POO)

---

## 🎯 Objetivo del ejercicio

Crear un programa robusto que **no se rompa** con entradas inválidas y que mantenga control de:
- Animales rescatados
- Especies disponibles
- Estados de adopción
- Reportes claros

📌 **Restricciones del ejercicio (cumplidas):**
- Archivo único: `RefugioAnimales.java`
- Interacción con `Scanner`
- Menú principal con `do-while`
- Todas las funciones son `static`
- Sin Programación Orientada a Objetos (por ahora)
- Validaciones obligatorias y mensajes claros

---

## 🧩 Estructuras de datos usadas

El sistema utiliza las estructuras solicitadas en el challenger:

- **List — Animales**
    - `List<String> animales`
    - Guarda los nombres de los animales registrados.

- **Set — Especies**
    - `Set<String> especies`
    - Guarda especies sin duplicados automáticamente.

- **Map — Animal → Estado**
    - `Map<String, String> estadoAnimal`
    - Maneja el estado de cada animal: `"Disponible"` o `"Adoptado"`.

- **Map — Animal → Especie**
    - `Map<String, String> animalEspecie`
    - Asocia cada animal con su especie.

> Nota: En esta versión, los estados se trabajan como texto (`"Disponible"` / `"Adoptado"`), tal como se ve en el código.

---

## 🧭 Menú del programa

El sistema funciona con el siguiente menú:
```markdown
=== REFUGIO DE ANIMALES ===

1) Registrar animal

2) Registrar especie

3) Marcar animal como adoptado

4) Mostrar animales disponibles

5) Mostrar animales adoptados

6) Mostrar reporte general

7) Salir
```


---

## ✅ Funcionalidades y validaciones

### 1) Registrar animal
Solicita:
- Nombre del animal
- Especie

Validaciones:
- No permite nombre vacío
- No permite especie vacía
- No permite especies inexistentes (deben registrarse antes en opción 2)
- No permite animales duplicados

Acciones:
- Agrega el animal a la `List`
- Guarda su especie en `animalEspecie`
- Asigna estado inicial `"Disponible"` en `estadoAnimal`

---

### 2) Registrar especie
Solicita:
- Nombre de especie

Validaciones:
- No permite vacío
- Evita duplicados automáticamente (por `Set`)

---

### 3) Marcar animal como adoptado
- Muestra animales disponibles
- Pregunta si desea adoptar (`si/no`)
- Si responde **si**, permite escribir el nombre del animal
- Cambia su estado a `"Adoptado"` si coincide (comparación `equalsIgnoreCase`)

---

### 4) Mostrar animales disponibles
- Imprime únicamente los animales con estado `"Disponible"`

---

### 5) Mostrar animales adoptados
- Imprime únicamente los animales con estado `"Adoptado"`
- Si no hay adoptados, muestra un mensaje informativo

---

### 6) Reporte general
Muestra una tabla con formato:

**Nombre | Especie | Estado**

Para cada animal registrado, el sistema imprime:
- Nombre
- Especie (o `"Sin especie"` si faltara)
- Estado (por defecto `"Disponible"` si faltara)

---

## ▶️ Cómo ejecutar el programa

### Opción A: Desde Terminal (recomendado)
1. Abre una terminal en la carpeta del proyecto (donde está `RefugioAnimales.java`)
2. Compila:

```bash
javac RefugioAnimales.java
```
3. Ejecuta:
```bash
java RefugioAnimales
```
---
### Opción B: IntelliJ IDEA

1. Abre la carpeta del proyecto en IntelliJ

2. Abre `RefugioAnimales.java`

3. Click derecho → Run **'RefugioAnimales.main()'**
---
### 🧪 Ejemplo rápido de uso (flujo típico)

1. Registrar especie: `Perro`

2. Registrar animal: `Firulais` + especie `Perro`

3. Mostrar disponibles: aparece `Firulais → Disponible`

4. Adoptar: escribir `Firulais`

5. Mostrar adoptados: aparece `Firulais → Adoptado`

6. Reporte general: muestra tabla con nombre, especie y estado

---

## 📂 Estructura del repositorio
```bash 
refugio-animales/
│
├── RefugioAnimales.java
├── README.md
└── .gitignore
```

---
## 👥 Integrantes del equipo

- Jonathan Fernandez

- Gabriel Lillo

- Naomi Nuñez

- Paulina Diaz

- Francisco Torres

- Martin Caviedes