### Ejercicio 1

_Para cumplir con los requerimientos de tiempo de respuesta y error rate establecidos, se puede proponer la siguiente configuración para el restclient:_

Se establece un **timeout de 400** ms para proporcionar suficiente margen de tiempo para recibir una respuesta de la API discounts-api. Dado que el tiempo de respuesta máximo de la API es de 400 ms, es importante asegurarse de que el timeout sea mayor para permitir la recepción de la respuesta en todos los casos.

Se pueden configurar **2 retries** en caso de que se agote el timeout o se produzca algún error. Al utilizar reintentos, nos damos la oportunidad de recibir una respuesta válida en caso de que haya una brecha breve en la disponibilidad de la API discounts-api o en caso de algún problema temporal.
