Changelog
[Unreleased]
Added

    REST API functionality to perform CRUD operations on a single entity as required by the project's objective.
    Spring Boot configuration with necessary libraries to support the API.
    Lombok library in the entity layer to reduce boilerplate code and promote good practices.
    Data Transfer Object (DTO) implementation for error handling in the discount layer.
    MapStruct integration in the mapper layer for mapping entities to DTOs and vice versa.
    JpaRepository interface usage in repositories layer for CRUD operations and custom search method.
    Service Layer design following SOLID principles, particularly the Interface Segregation Principle.
    NoteBookServiceImpl class as an implementation of the NoteBookService interface.
    Controller Layer with RESTful endpoints using annotations like @RestController, @RequestMapping, and @CrossOrigin.
    Swagger integration for API documentation.
    Docker configuration files for containerization and deployment.

Changed

    N/A

Deprecated

    N/A

Removed

    N/A

Fixed

    N/A

Security

    N/A

[0.1.0] - 2023-XX-XX

Initial release of the project.
Added

    Entity Layer
        Single entity representation with auto-generated identity for primary keys and column annotations for database mapping.
    Discount Layer
        Error capturing DTO for negative endpoint responses.
    Mapper Layer
        Configuration of MapStruct mappers for entity and DTO conversions, including lists.
    Repositories Layer
        Custom search method within the JpaRepository for entity searches.
    Service Layer
        Implementation of CRUD operations with exception handling.
        @Transactional annotation usage for database transaction management.
    Controller Layer
        Endpoints for saving, searching, updating, and deleting notebook entries.
        Exception handling for different HTTP response statuses.
    Swagger
        Auto-generation of API documentation based on controller annotations.
    Docker
        Deployment setup using Dockerfile and docker-compose for improved deployment process.
