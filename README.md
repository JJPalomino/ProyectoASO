# API REST - Simulación de Contrataciones de Tarjetas de Crédito

## Objetivo
Este desafío nos sumerge en el mundo de ASO, combinando conocimientos previos en Java, ASO, APX, Docker y Postman para la implementación de una API REST en el contexto de un banco. 

El objetivo principal es gestionar simulaciones de contrataciones de tarjetas de crédito para un cliente a través de un servicio que acepta peticiones POST con datos en formato JSON.

## Escenario ASO
Se espera recibir un JSON con detalles específicos sobre la simulación de contratación. El path puede ser gestionado tanto con `@PathParam` como con `@QueryParam`.

### Request del servicio ASO
- **PathParam**: `http://localhost:7500/TechArchitecture/helloWorld/v0/simulations/{nuip}`
- **QueryParam**: `http://localhost:7500/TechArchitecture/helloWorld/v0/simulations?nuip=123`

#### Ejemplo de request:
```json
{
  "details": {
    "offerType": "CARD_HOLDER",
    "limitAmount": {
      "amount": 200000,
      "currency": "EUR"
    },
    "product": {
      "id": "TDC",
      "subproduct": {
        "id": "AV"
      }
    }
  }
}
```

### Validaciones en la entrada
- `details.offerType` debe estar en mayúsculas.
- `details.limitAmount.amount` no puede ser nulo.
- `details.limitAmount.currency` no puede ser nulo ni vacío.
- `details.product.id` debe validarse con un regex para que sea igual a "TDC".
- `details.product.subproduct.id` solo puede contener de 0 a 2 caracteres.

## Response del servicio ASO
```json
{
  "data": {
    "id": "3242342343",
    "nuip": "123456789",
    "details": {
      "offerType": "CARD_HOLDER",
      "limitAmount": {
        "amount": 200000,
        "currency": "EUR"
      },
      "minimumAmount": {
        "amount": 180000,
        "currency": "EUR"
      },
      "maximumAmount": {
        "amount": 210000,
        "currency": "EUR"
      },
      "product": {
        "id": "TDC",
        "subproduct": {
          "id": "AV"
        }
      }
    }
  }
}
```

## Restricciones
### Mapeo entre capas
El flujo correcto debe respetar la arquitectura de capas: **facade → business → dao**.

### Validaciones en la entrada
- `details.offerType` debe ser el mismo en la entrada y salida, y solo aceptar mayúsculas.
- `details.limitAmount.amount` no puede ser nulo.
- `details.limitAmount.currency` no puede ser nulo ni vacío.
- `details.product.id` debe validarse con regex para que sea igual a "TDC".
- `details.product.subproduct.id` solo puede contener de 0 a 2 caracteres.

### Validaciones en la salida
- `data.id` debe ser aleatorio y de 10 caracteres.
- `data.nuip` debe ser el mismo `nuip` recibido en la URL.
- `data.details.limitAmount.amount` debe ser el mismo de la entrada.
- `data.details.minimumAmount.amount` debe ser el 90% de `details.limitAmount.amount`.
- `data.details.maximumAmount.amount` debe ser el 105% de `details.limitAmount.amount`.
- `data.details.minimumAmount.currency` y `data.details.maximumAmount.currency` deben coincidir con `details.limitAmount.currency`.
- `data.details.product.id` debe ser el mismo que el de entrada.
- `data.details.product.subproduct.id` debe ser el mismo que el de entrada.

## Resultados
Tuve un problema al momento de consumir en Postman, porque me marcaba un error 500

![Image](https://github.com/user-attachments/assets/089d0cb5-9c00-4bd0-819c-8fa90918c337)

Estuve revisando el código mucho tiempo y no supe como corregir el error, porque al hacer un Debug 'Test' en donde se hacía el mapeo, y  me decía que Cannot find local variable 'detailsin'

![Image](https://github.com/user-attachments/assets/3403e9b1-45f7-438f-9d77-4dbf0fb457cd)

![Image](https://github.com/user-attachments/assets/e5acaa12-37e7-41d7-bc69-85b0cea8d900)

El cual busque con un ctrl + shift + F no encontraba el 'detailsin'

![Image](https://github.com/user-attachments/assets/43a94ec4-4db9-4577-a6a2-0c5f750d9d13)

Por lo que no me dio tiempo de hacer los cambios pertinentes, sin embargo, como se vio en imagenes anteriores si estaban llegando los datos, pero el 'detailsin' no me dejo avanzar más. Además de que las primeras validaciones si las hacía.

![Image](https://github.com/user-attachments/assets/ec34abdd-36de-490e-9aaf-f6314c6820bc)
