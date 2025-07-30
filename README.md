# Library Management System

A comprehensive web-based library management system built with Spring Boot, featuring dynamic data structures and algorithms implementation for efficient book and student management.

## 🚀 Features

- **Book Management**: Add, update, delete, and search books
- **Student Registration**: Manage student accounts and information
- **Borrowing System**: Handle book lending and returns
- **Queue Management**: Waiting list system for popular books
- **Overdue Tracking**: Monitor and track overdue books
- **Statistical Reports**: Generate usage and inventory reports
- **Web Interface**: User-friendly web interface with Bootstrap styling

## 🏗️ Architecture

This project implements a modern Spring Boot web application with:

- **MVC Pattern**: Model-View-Controller architecture
- **Data Persistence**: PostgreSQL database with JPA/Hibernate
- **Web Layer**: Thymeleaf templating engine with Bootstrap UI
- **RESTful Design**: Clean REST API endpoints

## 📊 Data Structures & Algorithms

The system leverages various data structures and algorithms for optimal performance:

### Data Structures Used:
- **HashMap**: Fast book and student lookup operations
- **ArrayList**: Maintaining ordered collections
- **LinkedList**: Queue system implementation
- **PriorityQueue**: Priority-based waiting system
- **Stack**: Temporary data storage and operations

### Algorithms Implemented:
- **Linear Search**: Book searching functionality
- **Hash Search**: Fast ISBN-based lookups
- **Queue Operations**: Efficient queue management
- **Tree Traversal**: Category-based book grouping

## 🛠️ Technology Stack

- **Backend**: Spring Boot 2.7.18
- **Database**: PostgreSQL
- **ORM**: Spring Data JPA / Hibernate
- **Frontend**: Thymeleaf + Bootstrap 5.1.3
- **Build Tool**: Maven
- **Java Version**: 11+

## 📋 Prerequisites

Before running this application, make sure you have:

- Java 11 or higher
- Maven 3.6+
- PostgreSQL 12+
- Git

## ⚙️ Installation & Setup

### 1. Clone the Repository
```bash
git clone <repository-url>
cd library-management-system
```

### 2. Database Setup
1. Install PostgreSQL and create a database named `kutuphane`
2. Update database credentials in `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/kutuphane
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 3. Build and Run
```bash
# Compile the project
mvn clean compile

# Run the application
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## 🚀 Usage

### Starting the Application
1. Ensure PostgreSQL is running
2. Run the Spring Boot application
3. Open your browser and navigate to `http://localhost:8080`

### Main Features Access
- **Home Page**: Overview of library statistics
- **Books**: Manage book inventory
- **Students**: Handle student registrations
- **Borrowing**: Process book loans and returns
- **Reports**: View system statistics

## 🧪 Testing

Run the test suite:
```bash
mvn test
```

## 📁 Project Structure

```
src/
├── main/
│   ├── java/com/library/
│   │   ├── LibraryApplication.java      # Main application class
│   │   ├── controller/                  # Web controllers
│   │   ├── model/                      # Entity classes
│   │   ├── repository/                 # Data access layer
│   │   └── service/                    # Business logic layer
│   └── resources/
│       ├── application.properties      # Configuration
│       ├── static/                     # Static web assets
│       └── templates/                  # Thymeleaf templates
└── test/                              # Test classes
```

## 🔧 Configuration

Key configuration options in `application.properties`:

- **Database**: PostgreSQL connection settings
- **JPA**: Hibernate configuration
- **Server**: Port and context settings
- **Thymeleaf**: Template engine configuration
- **Logging**: Debug and SQL logging levels

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 API Endpoints

### Books
- `GET /books` - List all books
- `POST /books` - Add new book
- `GET /books/{id}` - Get book details
- `PUT /books/{id}` - Update book
- `DELETE /books/{id}` - Delete book

### Students
- `GET /students` - List all students
- `POST /students` - Register new student
- `GET /students/{id}` - Get student details

### Borrowing
- `POST /borrow` - Borrow a book
- `POST /return` - Return a book
- `GET /borrowed` - List borrowed books

## 🐛 Troubleshooting

### Common Issues:

1. **Database Connection Error**
   - Verify PostgreSQL is running
   - Check database credentials in `application.properties`

2. **Port Already in Use**
   - Change server port in `application.properties`
   - Kill existing processes on port 8080

3. **Build Failures**
   - Ensure Java 11+ is installed
   - Run `mvn clean install` to resolve dependencies

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👥 Authors

- Library Management System Team

## 🙏 Acknowledgments

- Spring Boot community for excellent documentation
- PostgreSQL team for robust database system
- Bootstrap team for responsive UI components

---

For more information or support, please open an issue in the repository.