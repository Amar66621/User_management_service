# User Management System

## Installation

1. Clone the repository:
```
git clone https://github.com/your-username/user-management-system.git
```
2. Navigate to the project directory:
```
cd user-management-system
```
3. Build the project using Maven:
```
mvn clean install
```
4. Run the application:
```
java -jar target/user-management-system.jar
```

## Usage

The User Management System provides the following functionality:

1. **User Registration**: Users can register by providing their username, email, password, gender, age, and phone number.
2. **User Login**: Users can log in to the system using their username and password.
3. **Password Reset**: Users can reset their password by providing their email, new password, and confirming the new password.
4. **User Update**: Users can update their profile information, such as username, email, age, gender, and phone number.
5. **Admin Functions**: Administrators can perform the following actions:
   - Fetch a specific user by their ID and role.
   - Fetch all users by their role (e.g., student, teacher).
   - Delete a user by their ID and role.

## API

The application exposes the following API endpoints:

1. **User Registration**: `POST /api/user/register`
2. **User Login**: `POST /api/login`
3. **Password Reset**: `POST /api/user/passwordreset`
4. **User Update**: `PUT /api/user/update/{id}`
5. **Fetch User by ID and Role**: `GET /api/admin/{role}/{id}`
6. **Fetch Users by Role**: `GET /api/admin/{role}`
7. **Delete User by ID and Role**: `DELETE /api/admin/{role}/{id}`

## Contributing

Contributions to the User Management System are welcome. To contribute, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and commit them.
4. Push your changes to your forked repository.
5. Create a pull request to the main repository.

## License

This project is licensed under the [MIT License](LICENSE).

## Testing

The User Management System includes unit tests for the core functionality. To run the tests, execute the following command:

```
mvn test
```

The tests cover the following areas:

- User registration
- User login
- Password reset
- User update
- Admin functions (fetch user, fetch users, delete user)
