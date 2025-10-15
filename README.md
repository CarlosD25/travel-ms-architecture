# Arquitectura de Microservicios de Viajes

Este proyecto implementa una arquitectura de microservicios para una agencia de viajes ficticia. Consiste en varios servicios que se comunican entre sí a través de un API Gateway.

## Servicios

- **gateway-service**: Punto de entrada único para todas las peticiones. Gestiona el enrutamiento, el balanceo de carga, la seguridad (rate limiting) y la resiliencia (circuit breaker).
- **itinerary-service**: Gestiona la búsqueda y los detalles de los itinerarios de viaje (vuelos + hotel).
- **booking-service**: Gestiona la creación y consulta de reservas.
- **redis**: Utilizado por el `gateway-service` para el control de peticiones (rate limiting).

## Prerrequisitos

Asegúrate de tener instalados los siguientes componentes en tu sistema:
- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/install/)

## Ejecución del Proyecto

1.  Clona este repositorio en tu máquina local.
2.  Abre una terminal en el directorio raíz del proyecto.
3.  Ejecuta el siguiente comando para construir las imágenes y levantar todos los servicios en segundo plano:

    ```bash
    docker compose up --build -d
    ```

4.  Los servicios estarán disponibles en los siguientes puertos en tu `localhost`:
    - **API Gateway**: `8080`
    - **Itinerary Service**: `8081` (accesible a través del gateway)
    - **Booking Service**: `8082` (accesible a través del gateway)
    - **Redis**: `6379`

## Pruebas de Endpoints

Todas las peticiones deben dirigirse al API Gateway en el puerto `8080` y deben incluir la cabecera `X-Api-Key` para cumplir con el limitador de peticiones. El valor de la clave puede ser cualquier cadena de texto.

### Probar el Itinerary Service

Este endpoint devuelve los detalles de un itinerario específico.

#### Con `xh`
```bash
xh get http://localhost:8080/api/public/itinerary/details/ITI-BOG-MAD-20251210-20251220-001 X-Api-Key:some-key
```

#### Con `curl`
```bash
curl -X GET -H "X-Api-Key: some-key" http://localhost:8080/api/public/itinerary/details/ITI-BOG-MAD-20251210-20251220-001
```

### Probar el Booking Service

Este endpoint devuelve los detalles de una reserva específica.

#### Con `xh`
```bash
xh get http://localhost:8080/api/public/booking/reservations/RES-9001001 X-Api-Key:some-key
```

#### Con `curl`
```bash
curl -X GET -H "X-Api-Key: some-key" http://localhost:8080/api/public/booking/reservations/RES-9001001
```
