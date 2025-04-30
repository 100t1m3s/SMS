-- Ensure the 'users' table exists
CREATE TABLE IF NOT EXISTS users
(
    id              UUID PRIMARY KEY,
    name            VARCHAR(255)        NOT NULL,
    email           VARCHAR(255) UNIQUE NOT NULL,
    address         VARCHAR(255)        NOT NULL,
    date_of_birth   DATE                NOT NULL,
    registered_date DATE                NOT NULL
    );

-- Insert well-known UUIDs for specific users
INSERT INTO users (id, name, email, address, date_of_birth, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174000',
       'John Doe',
       'johndoe@example.com',
       '123 colombo, Sri Lanka',
       '1985-06-15',
       '2024-01-10'
    WHERE NOT EXISTS (SELECT 1
                  FROM users
                  WHERE id = '123e4567-e89b-12d3-a456-426614174000');

INSERT INTO users (id, name, email, address, date_of_birth, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174001',
       'Sadu Ganesh',
       'saduganeshe@xample.com',
       '456 Chennai, India',
       '1990-09-23',
       '2023-12-01'
    WHERE NOT EXISTS (SELECT 1
                  FROM users
                  WHERE id = '123e4567-e89b-12d3-a456-426614174001');

INSERT INTO users (id, name, email, address, date_of_birth, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174002',
       'Prabash Nithish',
       'prabash123@example.com',
       '79, Colombo 07, Sri Lanka',
       '1998-03-12',
       '2022-06-20'
    WHERE NOT EXISTS (SELECT 1
                  FROM users
                  WHERE id = '123e4567-e89b-12d3-a456-426614174002');

INSERT INTO users (id, name, email, address, date_of_birth, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174003',
       'Bob Shadow',
       'bobshadow@example.com',
       '321 Pine St, Metland',
       '2001-11-30',
       '2022-05-14'
    WHERE NOT EXISTS (SELECT 1
                  FROM users
                  WHERE id = '123e4567-e89b-12d3-a456-426614174003');

INSERT INTO users (id, name, email, address, date_of_birth, registered_date)
SELECT '123e4567-e89b-12d3-a456-426614174004',
       'Shakya Kodisinghe',
       'shakya2000@example.com',
       '38, Gampaha, Colombo',
       '2001-12-25',
       '2024-03-01'
    WHERE NOT EXISTS (SELECT 1
                  FROM users
                  WHERE id = '123e4567-e89b-12d3-a456-426614174004');

-- Insert well-known UUIDs for specific users
INSERT INTO users (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174005',
       'Michael Green',
       'michaelgreen@example.com',
       '987 Cedar St, Springfield',
       '1988-07-25',
       '2024-02-15'
    WHERE NOT EXISTS (SELECT 1 FROM users WHERE id = '223e4567-e89b-12d3-a456-426614174005');

INSERT INTO users (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174006',
       'Sarah Taylor',
       'sarahtaylor@example.com',
       '123 Birch St, Shelbyville',
       '1992-04-18',
       '2023-08-25'
    WHERE NOT EXISTS (SELECT 1 FROM users WHERE id = '223e4567-e89b-12d3-a456-426614174006');

INSERT INTO users (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174007',
       'David Wilson',
       'davidwilson@example.com',
       '456 Ash St, Capital City',
       '1975-01-11',
       '2022-10-10'
    WHERE NOT EXISTS (SELECT 1 FROM users WHERE id = '223e4567-e89b-12d3-a456-426614174007');

INSERT INTO users (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174008',
       'Laura White',
       'laurawhite@example.com',
       '789 Palm St, Springfield',
       '1989-09-02',
       '2024-04-20'
    WHERE NOT EXISTS (SELECT 1 FROM users WHERE id = '223e4567-e89b-12d3-a456-426614174008');

INSERT INTO users (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174009',
       'James Harris',
       'james.harris@example.com',
       '321 Cherry St, Shelbyville',
       '1993-11-15',
       '2023-06-30'
    WHERE NOT EXISTS (SELECT 1 FROM users WHERE id = '223e4567-e89b-12d3-a456-426614174009');

INSERT INTO users (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174010',
       'Emma Moore',
       'emma.moore@example.com',
       '654 Spruce St, Capital City',
       '2000-08-09',
       '2023-01-22'
    WHERE NOT EXISTS (SELECT 1 FROM users WHERE id = '223e4567-e89b-12d3-a456-426614174010');

INSERT INTO users (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174011',
       'Ethan Martinez',
       'ethanmartinez@example.com',
       '987 Redwood St, Springfield',
       '1984-05-03',
       '2024-05-12'
    WHERE NOT EXISTS (SELECT 1 FROM users WHERE id = '223e4567-e89b-12d3-a456-426614174011');

INSERT INTO users (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174012',
       'Sophia Clark',
       'sophiaclark@example.com',
       '123 Hickory St, Shelbyville',
       '2003-12-25',
       '2022-11-11'
    WHERE NOT EXISTS (SELECT 1 FROM users WHERE id = '223e4567-e89b-12d3-a456-426614174012');

INSERT INTO users (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174013',
       'Daniel Lewis',
       'daniellewis@example.com',
       '456 Cypress St, Capital City',
       '2005-06-08',
       '2023-09-19'
    WHERE NOT EXISTS (SELECT 1 FROM users WHERE id = '223e4567-e89b-12d3-a456-426614174013');

INSERT INTO users (id, name, email, address, date_of_birth, registered_date)
SELECT '223e4567-e89b-12d3-a456-426614174014',
       'Isabella Walker',
       'isabellawalker@example.com',
       '789 Willow St, Springfield',
       '2002-10-17',
       '2024-03-29'
    WHERE NOT EXISTS (SELECT 1 FROM users WHERE id = '223e4567-e89b-12d3-a456-426614174014');
