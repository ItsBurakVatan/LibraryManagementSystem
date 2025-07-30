# Library Management System

A comprehensive web-based library management system built with Spring Boot, PostgreSQL, and Thymeleaf. This system provides complete functionality for managing books, students, borrowing records, and library operations.

## 🚀 Features

### Core Functionality
- **Book Management**: Add, search, and manage books with ISBN, title, author, category, and copy tracking
- **Student Management**: Register and manage students with borrowing limits
- **Borrowing System**: Complete borrow/return workflow with due date tracking
- **Overdue Management**: Track and manage overdue books with fine calculations
- **Statistics Dashboard**: Real-time library statistics and reports
- **Search Functionality**: Advanced search by title, author, category, and student information

### Technical Features
- **RESTful API**: Clean REST endpoints for all operations
- **Database Integration**: PostgreSQL with JPA/Hibernate ORM
- **Web Interface**: Modern responsive UI with Bootstrap 5
- **Form Validation**: Comprehensive input validation and error handling
- **Date Management**: Proper date formatting and timezone handling

## 🛠️ Technology Stack

- **Backend**: Spring Boot 2.7.18
- **Database**: PostgreSQL 42.7.2
- **ORM**: Spring Data JPA with Hibernate
- **Frontend**: Thymeleaf templates with Bootstrap 5.1.3
- **Java Version**: 11
- **Build Tool**: Maven

## 📋 Prerequisites

Before running this application, make sure you have the following installed:

- **Java 11** or higher
- **Maven 3.6** or higher
- **PostgreSQL 12** or higher
- **Git** (for cloning the repository)

## 🗄️ Database Setup

### PostgreSQL Configuration

1. **Install PostgreSQL** on your system
2. **Create Database**:
   ```sql
   CREATE DATABASE kutuphane;
   ```

3. **Database Connection Settings** (already configured in `application.properties`):
   - **Host**: localhost
   - **Port**: 5432
   - **Database**: kutuphane
   - **Username**: postgres
   - **Password**: 241308

### Database Schema

The application uses JPA/Hibernate with automatic schema generation. The main entities are:

#### Books Table (`books`)
- `isbn` (Primary Key): Book ISBN number
- `title`: Book title
- `author`: Book author
- `category`: Book category/genre
- `total_copies`: Total number of copies
- `available_copies`: Available copies for borrowing
- `publish_date`: Publication date
- `created_at`: Record creation date

#### Students Table (`students`)
- `student_id` (Primary Key): Unique student identifier
- `name`: Student full name
- `email`: Student email address
- `phone`: Student phone number
- `max_borrow_limit`: Maximum books student can borrow (default: 5)
- `created_at`: Record creation date

#### Borrow Records Table (`borrow_records`)
- `record_id` (Primary Key): Unique borrow record identifier
- `student_id`: Reference to student
- `book_isbn`: Reference to book ISBN
- `borrow_date`: Date when book was borrowed
- `due_date`: Expected return date
- `return_date`: Actual return date (null if not returned)
- `is_returned`: Boolean flag for return status
- `fine_amount`: Calculated fine for overdue books
- `created_at`: Record creation date

## 🚀 Installation & Setup

### 1. Clone the Repository
```bash
git clone <repository-url>
cd LibraryManagementSystem
```

### 2. Configure Database
Update `src/main/resources/application.properties` with your PostgreSQL credentials:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/kutuphane
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 3. Build the Project
```bash
mvn clean install
```

### 4. Run the Application
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## 📖 Usage Guide

### Main Dashboard (`/`)
- View library statistics
- Quick access to all features
- System overview

### Book Management (`/books`)
- **View All Books**: List all books in the library
- **Search Books**: Search by title, author, or category
- **Add New Book**: Navigate to book addition form
- **Book Details**: View individual book information

### Student Management (`/students`)
- **View All Students**: List all registered students
- **Search Students**: Search by name or student ID
- **Add New Student**: Register new students
- **Student Details**: View student information and borrowing history

### Borrowing System
- **Borrow Books** (`/borrow`): Lend books to students
- **Return Books** (`/return`): Process book returns
- **Overdue Books** (`/overdue`): View and manage overdue books

### Statistics (`/statistics`)
- Total books and students
- Borrowing statistics
- Overdue book reports
- System analytics

## 🔧 Configuration

### Application Properties
Key configuration options in `application.properties`:

```properties
# Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/kutuphane
spring.datasource.username=postgres
spring.datasource.password=241308

# JPA/Hibernate Settings
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# Server Configuration
server.port=8080

# Date Format Settings
spring.mvc.date-format=yyyy-MM-dd
spring.jackson.date-format=yyyy-MM-dd
spring.jackson.time-zone=Europe/Istanbul
```

### Development vs Production
- **Development**: `spring.jpa.hibernate.ddl-auto=update` (auto-create tables)
- **Production**: `spring.jpa.hibernate.ddl-auto=validate` (validate schema)

## 📁 Project Structure

```
LibraryManagementSystem/
├── src/
│   ├── main/
│   │   ├── java/com/library/
│   │   │   ├── controller/
│   │   │   │   └── LibraryController.java
│   │   │   ├── model/
│   │   │   │   ├── Book.java
│   │   │   │   ├── Student.java
│   │   │   │   ├── BorrowRecord.java
│   │   │   │   └── Library.java
│   │   │   ├── repository/
│   │   │   │   ├── BookRepository.java
│   │   │   │   ├── StudentRepository.java
│   │   │   │   └── BorrowRecordRepository.java
│   │   │   ├── service/
│   │   │   │   └── LibraryService.java
│   │   │   └── LibraryApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       │   ├── css/style.css
│   │       │   └── js/script.js
│   │       └── templates/
│   │           ├── index.html
│   │           ├── books.html
│   │           ├── students.html
│   │           ├── borrow.html
│   │           ├── return.html
│   │           ├── overdue.html
│   │           ├── statistics.html
│   │           ├── add-book.html
│   │           └── add-student.html
│   └── test/
└── pom.xml
```

## 🔍 API Endpoints

### Book Management
- `GET /books` - List all books
- `GET /books/search` - Search books
- `GET /books/add` - Show add book form
- `POST /books/add` - Add new book

### Student Management
- `GET /students` - List all students
- `GET /students/search` - Search students
- `GET /students/add` - Show add student form
- `POST /students/add` - Add new student

### Borrowing Operations
- `GET /borrow` - Show borrow form
- `POST /borrow` - Process book borrowing
- `GET /return` - Show return form
- `POST /return` - Process book return
- `GET /overdue` - List overdue books

### Statistics
- `GET /` - Dashboard with statistics
- `GET /statistics` - Detailed statistics

## 🧪 Testing

Run the test suite:
```bash
mvn test
```

## 🚀 Deployment

### JAR File Creation
```bash
mvn clean package
```

### Running JAR File
```bash
java -jar target/library-management-system-1.0-SNAPSHOT.jar
```

### Docker Deployment (Optional)
Create a `Dockerfile`:
```dockerfile
FROM openjdk:11-jre-slim
COPY target/library-management-system-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

## 🔒 Security Considerations

- **Database Security**: Use strong passwords for PostgreSQL
- **Input Validation**: All forms include comprehensive validation
- **SQL Injection Prevention**: Using JPA/Hibernate ORM
- **XSS Prevention**: Thymeleaf template engine provides built-in protection

## 🐛 Troubleshooting

### Common Issues

1. **Database Connection Error**
   - Verify PostgreSQL is running
   - Check database credentials in `application.properties`
   - Ensure database `kutuphane` exists

2. **Port Already in Use**
   - Change `server.port` in `application.properties`
   - Kill existing process on port 8080

3. **Build Errors**
   - Ensure Java 11+ is installed
   - Run `mvn clean install`
   - Check Maven dependencies

## 📝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Submit a pull request

## 📄 License

This project is licensed under the MIT License.

## 👨‍💻 Author

Created as a data structures and algorithms project demonstrating:
- Object-Oriented Programming principles
- Database design and management
- Web application development
- RESTful API design
- Frontend-backend integration

## 🔄 Version History

- **v1.0-SNAPSHOT**: Initial release with core functionality
  - Book management system
  - Student registration
  - Borrowing workflow
  - Overdue tracking
  - Statistics dashboard

---

**Note**: This is a comprehensive library management system designed for educational purposes and can be extended for production use with additional security measures and features.
