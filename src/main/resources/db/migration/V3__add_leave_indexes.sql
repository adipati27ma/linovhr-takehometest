BEGIN;

CREATE INDEX idx_leave_employee
ON leave_requests(employee_id);

CREATE INDEX idx_leave_status
ON leave_requests(status);

CREATE INDEX idx_leave_dates
ON leave_requests(start_date, end_date);

COMMIT;