# User Service

## Инструкции по запуску проекта

1. Убедитесь, что установлены Java 17+, Maven, Docker.
2. Запустите PostgreSQL и Redis:
   ```bash
   docker-compose up -d
   ```
3. Пропишите настройки в `application.yml` (БД, Redis, JWT-секрет).
4. Выполните миграции Liquibase:
   ```bash
   mvn liquibase:update
   ```
5. Запустите приложение:
   ```bash
   mvn spring-boot:run
   ```
6. Запустите тесты:
   ```bash
   mvn test
   ```

## Технологии

- **Java 17** – основа проекта
- **Spring Boot 3** – фреймворк
- **Spring Data JPA** – работа с БД
- **PostgreSQL** – основная БД
- **Redis** – кэш пользователей
- **Liquibase** – миграции схемы
- **JWT (JJWT)** – авторизация
- **Testcontainers** – для тестов
- **Lombok** – автогенерация кода
- **MockMvc** – интеграционные тесты

## Архитектура и логика

- **Трехслойная архитектура**: API → Service → DAO.
- **JWT**: claim содержит userId, логин – через email+password или phone+password.
- **Ограничения данных**: у пользователя всегда минимум 1 email и phone, и один Account.
- **Обновление баланса**: `@Scheduled` раз в 30 секунд + ограничение до 207% от начального.
- **Изменение данных**: пользователь может изменить email/phone, если они не заняты другим.
- **Трансфер**: потокобезопасная операция, валидация и транзакция на уровне сервиса.
- **Кэширование Redis**: кэшируются пользователи, инвалидация при изменении.
- **Swagger** и логгирование – настраиваются отдельно (опционально).
- **Тесты**: покрытие ключевых операций unit + интеграционные через Testcontainers.
