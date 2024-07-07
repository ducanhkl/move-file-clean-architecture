# Move File Clean Architecture

## Overview
This repository implements a clean architecture for moving files. It is designed to separate concerns and make the codebase more maintainable.

## Requirements
- Java 8 or higher
- Gradle

## Architecture
### Domain Layer
The domain layer contains the core business logic of the application. It includes use cases that define the specific business rules and the logic to handle file operations such as checking if a file exists, ensuring a file is not a folder, and copying files. This layer is independent of any external frameworks or technologies, ensuring that the business logic remains decoupled from other parts of the system.

### Infrastructure Layer
The infrastructure layer handles the actual implementation details required to execute the business logic defined in the domain layer. It includes classes and adapters for file system operations, implementing the methods defined in the output ports. This layer interacts with the file system and other external systems, providing the necessary functionality for the domain layer to perform its operations.

For more information, visit the [GitHub repository](https://github.com/ducanhkl/move-file-clean-architecture).
