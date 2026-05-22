BEGIN;
CREATE TABLE leave_requests (
    id BIGSERIAL PRIMARY KEY,
    employee_id BIGINT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    total_days INT NOT NULL,
    reason TEXT NOT NULL,
    status VARCHAR(20) NOT NULL, -- PENDING/APPROVED/REJECTED
    rejection_reason TEXT,
    approved_at TIMESTAMP,
    approved_by BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100) NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by VARCHAR(100) NOT NULL,

    CONSTRAINT fk_employee
        FOREIGN KEY (employee_id)
        REFERENCES users(id),

    CONSTRAINT fk_approver
        FOREIGN KEY (approved_by)
        REFERENCES users(id)
);
COMMIT;