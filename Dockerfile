# =========================================
# STAGE 1 - BUILDDD
# =========================================

FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copiar pom.xml primero para cachear dependencias
COPY pom.xml .

RUN mvn clean dependency:go-offline

# Copiar código fuente
COPY src ./src

# Compilar proyecto
RUN mvn clean package -DskipTests


# =========================================
# STAGE 2 - RUNTIME
# =========================================

FROM eclipse-temurin:21-jre

WORKDIR /app

# Copiar jar generado
COPY --from=build /app/target/*.jar appArqHexagonal.jar

# Puerto aplicación
EXPOSE 8188

# Ejecutar aplicación
ENTRYPOINT ["java", "-jar", "appArqHexagonal.jar"]

# comandos principales para ejecutar la aplicación
# 1. Construir la imagen:
#    docker build --no-cache -t arquitecturahexagonal .
# 2. Ejecutar el contenedor:
#    docker run -d -p 8090:8188 --name apphex arquitecturahexagonal

