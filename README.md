# Taller de Automatización - Calidad de Software 2026-2
## Automatización de Pruebas con Scaffolding of ScreenPlay Architecture

Proyecto de automatización de pruebas end-to-end (E2E) desarrollado para el reto funcional del **Caso 5: Compra de artículos online en [Automation Exercise](https://automationexercise.com/)**, implementando el patrón de diseño **ScreenPlay**, **Serenity BDD**, **Cucumber (Gherkin)** y **Gradle**.

---

## 📋 Resumen del Caso Seleccionado (Caso 5)
* **Sitio Web:** [https://automationexercise.com/](https://automationexercise.com/)
* **Tipo:** Compra de artículos online (e-Commerce).
* **Alcance:** Realizar una prueba E2E completa que registre un usuario con datos válidos, seleccione productos del catálogo, los agregue al carrito de compras, proceda al checkout, complete la pasarela de pago con tarjeta de crédito y valide que la orden de compra quede exitosamente confirmada (`ORDER PLACED!`), complementado con escenarios alternos y de excepción.

---

## 🏛️ Arquitectura del Proyecto (Patrón Screenplay)

El proyecto fue generado mediante el scaffolding oficial `io.github.jumosqu12.screenplayarchitecture` y estructurado bajo las capas del patrón Screenplay:

```
CompraDeArticulosOnline/
├── src/
│   ├── main/java/co/com/automationexercise/compra/
│   │   ├── interactions/          # "La Menuda": Detalle técnico de bajo nivel
│   │   │   ├── Delay.java                 # Retardo configurable para sustentación/socialización
│   │   │   ├── EsperarElemento.java       # Esperas explícitas de estado de elementos
│   │   │   ├── JavaScriptClick.java       # Clicks JavaScript para evitar bloqueos por overlays/anuncios
│   │   │   └── ScrollTo.java              # Desplazamiento de vista centrado
│   │   ├── models/                # Objetos de negocio / POJOs
│   │   │   ├── Usuario.java               # Datos personales, de cuenta y de facturación
│   │   │   └── TarjetaCredito.java        # Datos de la tarjeta de crédito
│   │   ├── questions/             # Verificaciones de resultados esperados (Assertions)
│   │   │   ├── LaConfirmacionDeLaOrden.java # Valida mensaje "ORDER PLACED!"
│   │   │   ├── ElMensajeDeErrorRegistro.java# Valida "Email Address already exist!"
│   │   │   ├── ElUsuarioLogueado.java       # Valida estado de sesión
│   │   │   └── LosArticulosEnCarrito.java   # Valida cantidad de items en carrito
│   │   ├── tasks/                 # Tareas de negocio (alto nivel de abstracción)
│   │   │   ├── AbrirNavegador.java                  # Apertura y resiliencia ante Cloudflare
│   │   │   ├── RegistrarNuevoUsuario.java           # Flujo completo de registro
│   │   │   ├── IniciarSesion.java                   # Login con credenciales
│   │   │   ├── AgregarProductoAlCarrito.java        # Selección y adición al carrito
│   │   │   ├── AgregarMultiplesProductos.java       # Adición de varios productos
│   │   │   ├── ProcederAlCheckout.java              # Checkout y comentarios
│   │   │   ├── RealizarPago.java                    # Pasarela de pago con tarjeta
│   │   │   └── IntentarRegistroConEmailExistente.java # Intento fallido con email duplicado
│   │   ├── userinterfaces/        # Mapeo de elementos web (Page Objects / Targets)
│   │   │   ├── HomePage.java              # Navbar, catálogo de productos, modales
│   │   │   ├── LoginPage.java             # Formularios de login y nuevo registro
│   │   │   ├── RegistroPage.java          # Formulario detallado de cuenta y dirección
│   │   │   ├── CarritoPage.java           # Tabla de items y Proceed To Checkout
│   │   │   ├── CheckoutPage.java          # Dirección de entrega y Place Order
│   │   │   ├── PagoPage.java              # Formulario de tarjeta de crédito
│   │   │   └── ConfirmacionOrdenPage.java # Confirmación de orden y número de pedido
│   │   └── utils/                 # Utilidades generales
│   │       ├── Constantes.java            # URLs y constantes de negocio
│   │       └── DataGenerator.java         # Generador dinámico de datos aleatorios
│   └── test/
│       ├── java/co/com/automationexercise/compra/
│       │   ├── runners/
│       │   │   └── CompraArticulosRunner.java       # Runner JUnit con CucumberWithSerenity
│       │   └── stepdefinitions/
│       │       └── CompraArticulosStepDefinitions.java # Conexión Gherkin -> Tasks & Questions
│       └── resources/
│           ├── features/
│           │   └── compra_articulos_online.feature # Especificación Gherkin en español
│           └── serenity.conf                       # Configuración de WebDriver, Chrome y reporte
├── build.gradle                   # Dependencias, plugin Serenity y tareas Gradle
├── serenity.properties            # Propiedades globales de Serenity BDD
└── README.md
```

---

## 🎯 Batería de Pruebas (Gherkin)

Ubicación: `src/test/resources/features/compra_articulos_online.feature`

1. **Ruta Feliz (`@rutaFeliz @e2e`):**
   * Registro completo de usuario con información personal y de residencia.
   * Selección de un producto del catálogo y adición al carrito.
   * Proceso de checkout con validación de dirección y comentarios.
   * Pago con tarjeta de crédito (titular, número, CVC, vencimiento).
   * Verificación del resultado esperado: confirmación de la orden con el mensaje `"ORDER PLACED!"`.

2. **Camino Alterno (`@caminoAlterno`):**
   * Usuario autenticado agrega múltiples artículos al carrito de compras de manera secuencial.
   * Validación de productos en el carrito y avance al checkout.
   * Pago y confirmación de la orden de compra.

3. **Camino Excepcional (`@caminoExcepcional @negativo`):**
   * Creación previa y dinámica de un usuario en el sistema.
   * Intento deliberado de registrar una cuenta utilizando el mismo correo electrónico.
   * Verificación del resultado esperado: mensaje de advertencia del sistema `"Email Address already exist!"`.

---

## 📊 Cumplimiento de la Rúbrica de Evaluación

| Criterio | Puntos | Implementación en el Proyecto |
|---|---|---|
| **Cobertura y profundidad funcional** | 10 | Cobertura integral del reto: registro completo de usuario, adición de items simples y múltiples al carrito, checkout, pagos con tarjeta, confirmación de orden y validación de mensajes de error de negocio. |
| **Principios F.I.R.S.T** | 5 | **Fast:** Esperas explícitas inteligentes (`WaitUntil.the(...)`). <br>**Independent:** Cada escenario es completamente autónomo y no depende de estados previos; cierre de sesión y reinicio de stage con `OnStage.drawTheCurtain()`. <br>**Repeatable:** `DataGenerator` genera correos y datos aleatorios únicos (timestamps y UUIDs) en cada ejecución, eliminando falsos positivos por duplicidad. <br>**Self-validating:** Questions asertivas con matchers de Hamcrest (`containsString`, `equalTo`). <br>**Timely:** Diseñado modularmente para integración continua. |
| **Reportes de la prueba automatizada** | 10 | Generación automática del reporte HTML de **Serenity BDD** mediante la tarea `aggregate`, incluyendo capturas de pantalla de cada paso (`AFTER_EACH_STEP`), tiempos de ejecución y trazabilidad completa. |
| **Calidad del código y buenas prácticas** | 10 | Patrón Screenplay riguroso, principios SOLID, alta cohesión y bajo acoplamiento, UserInterfaces centralizadas con `Target`, modelos limpios (POJOs) y documentación JavaDoc en todas las clases. |
| **Creatividad e innovación** | 10 | Generador dinámico de datos aleatorios (`DataGenerator`), interacción `JavaScriptClick` para sobrepasar banners y overlays publicitarios de la web, y resiliencia ante la pantalla de carga/verificación inicial de Cloudflare. |
| **Socialización** | 55 | **Interacción `Delay` configurable:** Introduce pausas visuales controladas entre cada paso e interacción para que durante la sustentación en vivo frente al docente y compañeros se aprecie con total claridad la ejecución de cada acción en el navegador. |

---

## 🚀 Instrucciones de Ejecución

### 1. Ejecutar toda la batería de pruebas y generar el reporte Serenity
```powershell
.\gradlew test aggregate
```

### 2. Ejecutar únicamente el escenario de la Ruta Feliz (E2E)
```powershell
.\gradlew test "-Dcucumber.filter.tags=@rutaFeliz" aggregate
```

### 3. Ejecutar el Camino Alterno (Múltiples productos)
```powershell
.\gradlew test "-Dcucumber.filter.tags=@caminoAlterno" aggregate
```

### 4. Ejecutar el Camino Excepcional (Email existente)
```powershell
.\gradlew test "-Dcucumber.filter.tags=@caminoExcepcional" aggregate
```

---

## 📑 Visualización del Reporte Serenity BDD

Una vez finalizada la ejecución, el reporte interactivo consolidado se encuentra en:
* **Ruta del reporte:** `target/site/serenity/index.html`

Para abrirlo directamente en el navegador:
```powershell
Start-Process "target\site\serenity\index.html"
```
El reporte incluye:
* Resumen gráfico de escenarios aprobados (100% Passed).
* Desglose paso a paso de cada Task, Interaction y Question.
* Capturas de pantalla de cada acción en el navegador.
* Tiempos exactos y métricas de rendimiento.
