CREATE TABLE employees (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    employee_code VARCHAR(255),
    name VARCHAR(100),
    department VARCHAR(255),
    salary VARCHAR(100),
    email VARCHAR(100)
);

