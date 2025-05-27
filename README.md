# 🏥 MedLynx API

![Banner MedLynx](https://img.shields.io/badge/MedLynx-API-brightgreen?style=for-the-badge&logo=spring)

## 📋 Descripción

MedLynx API es una solución innovadora diseñada para profesionales de la salud y farmacias, que proporciona información en tiempo real sobre medicamentos, incluyendo:

- 📊 Precios actualizados
- 📜 Información legal y regulatoria
- 💊 Detalles de registro INVIMA
- 🏷️ Información comercial

## 🚀 Tecnologías

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4.5-6DB33F?style=flat-square&logo=spring)
![MongoDB](https://img.shields.io/badge/MongoDB-4.4+-47A248?style=flat-square&logo=mongodb)
![Maven](https://img.shields.io/badge/Maven-3.8+-C71A36?style=flat-square&logo=apache-maven)
![Lombok](https://img.shields.io/badge/Lombok-Latest-red?style=flat-square&logo=lombok)

## ⚙️ Requisitos Previos

- Java JDK 17 o superior
- MongoDB 4.4+
- Maven 3.8+
- IDE compatible con Spring Boot (recomendado: IntelliJ IDEA)

## 🛠️ Configuración

1. **Clonar el repositorio:**

bash git clone [medlynx.git](https://github.com/aleicer/medlynx.git)


2. **Configurar variables de entorno:**

Crear un archivo `.env` en la raíz del proyecto:

### properties 
- MONGODB_URI=tu_uri_mongodb 
- MEDICINES_INVIMA_VIGENTE_API=url_api_invima_vigente 
- MEDICINES_INVIMA_RENOVACION_API=url_api_invima_renovacion 
- MEDICINES_INVIMA_VENCIDO_API=url_api_invima_vencido 
- MEDICINES_INVIMA_OTRO_API=url_api_invima_otro 
- TOKEN_API_DATOSGOV=tu_token_api


3. **Compilar el proyecto:**

bash mvn clean install


4. **Ejecutar la aplicación:**

bash mvn spring-boot:run


## 🌐 Endpoints API

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/medicines/search` | Búsqueda de medicamentos |
| GET | `/api/medicines/legal-info` | Información legal |
| GET | `/api/medicines/prices` | Consulta de precios |

## 📚 Documentación

La documentación completa de la API está disponible en:

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)


## 🤝 Contribución

1. Fork del repositorio
2. Crea tu rama de características (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add: nueva característica'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 👥 Autores

- **Aleicer Vesga** - *Trabajo Grado* - [GitGub](https://github.com/aleicer)

## 🙏 Agradecimientos

- IU Digital
- Datos Abiertos Colombia
- INVIMA

---
<p align="center">
  Hecho con ❤️ para la comunidad médica y farmacéutica
</p>

