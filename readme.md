# backendDevTest

- [backendDevTest](#backenddevtest)
  - [Prueba técnica de desarrollo backend - 🇪🇸](#prueba-técnica-de-desarrollo-backend---)
    - [Pruebas y autoevaluación](#pruebas-y-autoevaluación)
    - [Evaluación](#evaluación)
  - [Backend dev technical test - 🇬🇧](#backend-dev-technical-test---)
    - [Testing and Self-evaluation](#testing-and-self-evaluation)
    - [Evaluation](#evaluation)

## Prueba técnica de desarrollo backend - 🇪🇸

Queremos ofrecer una nueva función a nuestros clientes mostrando productos similares al que están viendo actualmente. Para hacer esto, acordamos con nuestras aplicaciones front-end crear una nueva operación de API REST que les proporcionará los detalles del producto de productos similares para uno determinado. [Aquí](./similarProducts.yaml) está el contrato que acordamos.

Ya tenemos un punto final que proporciona ID de producto similares para uno determinado. También tenemos otro punto final que devuelve el detalle del producto por ID del producto. [Aquí](./existingApis.yaml) está la documentación de las API existentes.

**Cree una aplicación Spring Boot que exponga la API REST acordada en el puerto 5000.**

![Diagrama](./assets/diagram.jpg "Diagrama")

Tenga en cuenta que se proporcionan los componentes _Test_ y _Mocks_, solo debe implementar _yourApp_.

### Pruebas y autoevaluación

Puede ejecutar la misma prueba que realizaremos en su solicitud. Sólo necesitas tener instalado Docker.

En primer lugar, es posible que deba habilitar el uso compartido de archivos para la carpeta "compartida" en el panel de su ventana acoplable -> configuración -> recursos -> uso compartido de archivos.

Luego puedes iniciar los simulacros y otra infraestructura necesaria con el siguiente comando.

```docker
docker-compose up -d simulado influxdb grafana
```

Compruebe que los simulacros funcionen con una solicitud de muestra a [http://localhost:3001/product/1/similarids](http://localhost:3001/product/1/similarids).

Para ejecutar la ejecución de prueba:

```docker
docker-compose run --rm k6 run scripts/test.js
```

Explore [http://localhost:3000/d/Le2Ku9NMk/k6- Performance-test](http://localhost:3000/d/Le2Ku9NMk/k6-Performance-test) para ver los resultados.

### Evaluación

Se considerarán los siguientes temas:

- Claridad y mantenibilidad del código.
- Actuación
- Resiliencia

## Backend dev technical test - 🇬🇧

We want to offer a new feature to our customers showing similar products to the one they are currently seeing. To do this we agreed with our front-end applications to create a new REST API operation that will provide them the product detail of the similar products for a given one. [Here](./similarProducts.yaml) is the contract we agreed.

We already have an endpoint that provides the product Ids similar for a given one. We also have another endpoint that returns the product detail by product Id. [Here](./existingApis.yaml) is the documentation of the existing APIs.

**Create a Spring boot application that exposes the agreed REST API on port 5000.**

![Diagram](./assets/diagram.jpg "Diagram")

Note that _Test_ and _Mocks_ components are given, you must only implement _yourApp_.

### Testing and Self-evaluation

You can run the same test we will put through your application. You just need to have docker installed.

First of all, you may need to enable file sharing for the `shared` folder on your docker dashboard -> settings -> resources -> file sharing.

Then you can start the mocks and other needed infrastructure with the following command.

```docker
docker-compose up -d simulado influxdb grafana
```

Check that mocks are working with a sample request to [http://localhost:3001/product/1/similarids](http://localhost:3001/product/1/similarids).

To execute the test run:

```docker
docker-compose run --rm k6 run scripts/test.js
```

Browse [http://localhost:3000/d/Le2Ku9NMk/k6-performance-test](http://localhost:3000/d/Le2Ku9NMk/k6-performance-test) to view the results.

### Evaluation

The following topics will be considered:

- Code clarity and maintainability
- Performance
- Resilience
