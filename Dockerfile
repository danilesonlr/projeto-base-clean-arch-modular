# Etapa 1: Build com Gradle e JDK 17
FROM gradle:8.7-jdk17 AS build
WORKDIR /app

# Copia arquivos de build e dependências
COPY build.gradle settings.gradle gradle.properties* ./
COPY gradle ./gradle

# Resolve dependências
RUN gradle build --no-daemon || true

# Copia o restante do código
COPY . .

# Compila a aplicação (sem testes)
RUN gradle bootJar --no-daemon

# Etapa 2: Runtime com JDK 17
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copia o JAR gerado da etapa de build
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
