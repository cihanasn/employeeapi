-- Employee tablosunu oluştur
CREATE TABLE employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(100),
    salary DOUBLE
);

-- Örnek veri ekle
INSERT INTO employee (name, department, salary) VALUES ('Ali', 'IT', 60000);
INSERT INTO employee (name, department, salary) VALUES ('Ayşe', 'HR', 55000);
