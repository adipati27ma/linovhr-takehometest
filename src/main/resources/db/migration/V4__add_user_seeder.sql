-- Seeder Users & Managers
-- Password for all user: password
-- BCrypt hash for "password"
-- $2a$10$DowJonesIndexExampleHashReplaceWithRealHash1234567890

INSERT INTO users (
    employee_code,
    full_name,
    email,
    password,
    user_role,
    annual_leave_quota,
    created_by,
    updated_by
) VALUES
(
    'EMP001',
    'Andi Saputra',
    'andi.saputra@company.com',
    '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy',
    'EMPLOYEE',
    12,
    'SYSTEM',
    'SYSTEM'
),
(
    'EMP002',
    'Budi Hartono',
    'budi.hartono@company.com',
    '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy',
    'EMPLOYEE',
    12,
    'SYSTEM',
    'SYSTEM'
),
(
    'EMP003',
    'Citra Lestari',
    'citra.lestari@company.com',
    '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy',
    'EMPLOYEE',
    12,
    'SYSTEM',
    'SYSTEM'
),
(
    'MGR001',
    'Dewi Anggraini',
    'dewi.anggraini@company.com',
    '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy',
    'MANAGER',
    12,
    'SYSTEM',
    'SYSTEM'
),
(
    'MGR002',
    'Eko Prasetyo',
    'eko.prasetyo@company.com',
    '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy',
    'MANAGER',
    12,
    'SYSTEM',
    'SYSTEM'
);