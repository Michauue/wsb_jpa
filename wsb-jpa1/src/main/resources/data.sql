INSERT INTO ADDRESS (CITY, ADDRESS_LINE1, ADDRESS_LINE2, POSTAL_CODE)
VALUES
    ('New York', 'Broadway 123', 'Apt. 1A', '10001'),
    ('Los Angeles', 'Main Street 456', NULL, '90001'),
    ('Chicago', 'Oak Street 789', 'Suite 100', '60601'),
    ('Houston', 'Elm Street 321', NULL, '77002'),
    ('Phoenix', 'Palm Street 654', 'Unit B', '85001'),
    ('Philadelphia', 'Maple Street 987', 'Floor 3', '19019'),
    ('San Antonio', 'Cedar Street 159', NULL, '78201'),
    ('San Diego', 'Willow Street 357', 'Apt. 2B', '92101'),
    ('Dallas', 'Pine Street 246', NULL, '75201'),
    ('San Jose', 'Birch Street 468', NULL, '95101'),
    ('Houston', 'Maple Street 123', 'Apt. 1B', '77001'),
    ('Phoenix', 'Oak Street 456', NULL, '85001'),
    ('Philadelphia', 'Elm Street 789', 'Suite 200', '19001'),
    ('San Antonio', 'Cedar Street 321', NULL, '78201'),
    ('San Diego', 'Willow Street 654', 'Unit C', '92101'),
    ('Dallas', 'Palm Street 987', 'Floor 2', '75201'),
    ('San Jose', 'Pine Street 159', NULL, '95101'),
    ('Austin', 'Birch Street 357', 'Apt. 3B', '78701'),
    ('Jacksonville', 'Cypress Street 468', NULL, '32201'),
    ('Indianapolis', 'Juniper Street 246', NULL, '46201');


INSERT INTO DOCTOR (FIRST_NAME, LAST_NAME, TELEPHONE_NUMBER, EMAIL, DOCTOR_NUMBER, ADDRESS_ID, SPECIALIZATION)
VALUES
    ('John', 'Doe', '123456789', 'john.doe@example.com', 'DOC123', 1, 'GENERAL_PRACTITIONER'),
    ('Jane', 'Smith', '987654321', 'jane.smith@example.com', 'DOC456', 2, 'CARDIOLOGIST'),
    ('Michael', 'Johnson', '555123456', 'michael.johnson@example.com', 'DOC789', 3, 'PEDIATRICIAN'),
    ('Sarah', 'Brown', '999888777', 'sarah.brown@example.com', 'DOC101', 4, 'DERMATOLOGIST'),
    ('David', 'Wilson', '333444555', 'david.wilson@example.com', 'DOC202', 5, 'NEUROLOGIST'),
    ('Emily', 'Taylor', '222333444', 'emily.taylor@example.com', 'DOC303', 6, 'PSYCHIATRIST'),
    ('James', 'Anderson', '777888999', 'james.anderson@example.com', 'DOC404', 7, 'ONCOLOGIST'),
    ('Olivia', 'Martinez', '111222333', 'olivia.martinez@example.com', 'DOC505', 8, 'GASTROENTEROLOGIST'),
    ('William', 'Lee', '123123123', 'william.lee@example.com', 'DOC606', 9, 'ORTHOPEDIST'),
    ('Ava', 'Garcia', '111222333', 'ava.garcia@example.com', 'DOC707', 10, 'ENDOCRINOLOGIST');


INSERT INTO PATIENT (FIRST_NAME, LAST_NAME, TELEPHONE_NUMBER, EMAIL, PATIENT_NUMBER, ADDRESS_ID, DATE_OF_BIRTH)
VALUES
    ('Alice', 'Smith', '111111111', 'alice.smith@example.com', 'PAT123', 11, '1990-05-01'),
    ('Bob', 'Johnson', '222222222', 'bob.johnson@example.com', 'PAT456', 12, '1985-08-15'),
    ('Eva', 'White', '333333333', 'eva.white@example.com', 'PAT789', 13, '1976-12-30'),
    ('Liam', 'Johnson', '444444444', 'liam.johnson@example.com', 'PAT101', 14, '2000-02-20'),
    ('Sophia', 'Taylor', '555555555', 'sophia.taylor@example.com', 'PAT202', 15, '1995-04-10'),
    ('Mia', 'Martinez', '666666666', 'mia.martinez@example.com', 'PAT303', 16, '1988-07-05'),
    ('Oliver', 'Brown', '777777777', 'oliver.brown@example.com', 'PAT404', 17, '1993-09-25'),
    ('Noah', 'Lee', '888888888', 'noah.lee@example.com', 'PAT505', 18, '1979-11-15'),
    ('Emma', 'Garcia', '999999999', 'emma.garcia@example.com', 'PAT606', 19, '1983-03-05'),
    ('Ava', 'Wilson', '123123123', 'ava.wilson@example.com', 'PAT707', 20, '1998-06-12');


INSERT INTO VISIT (DESCRIPTION, TIME, DOCTOR_ID, PATIENT_ID)
VALUES
    ('Check-up appointment', '2024-05-10 09:00:00', 1, 1),
    ('Medical consultation', '2024-05-12 14:30:00', 1, 2),
    ('Blood test', '2024-05-14 11:00:00', 2, 3),
    ('Follow-up visit', '2024-05-15 16:45:00', 3, 4),
    ('Neurology consultation', '2024-05-17 10:30:00', 4, 5),
    ('Ultrasound examination', '2024-05-18 13:15:00', 5, 6),
    ('Treatment recommendation', '2024-05-19 11:45:00', 6, 7),
    ('Follow-up visit', '2024-05-22 08:30:00', 1, 8),
    ('Dietary consultation', '2024-05-23 15:20:00', 1, 9),
    ('Physical examination', '2024-05-25 09:30:00', 7, 9);

INSERT INTO MEDICAL_TREATMENT (DESCRIPTION, TYPE, VISIT_ID)
VALUES
    ('Prescription for antibiotics', 'MEDICATION', 1),
    ('X-ray examination', 'DIAGNOSTIC', 2),
    ('Physical therapy session', 'THERAPY', 3),
    ('Referral to specialist', 'CONSULTATION', 4),
    ('Blood pressure monitoring', 'MONITORING', 5),
    ('Wound dressing', 'PROCEDURE', 6),
    ('Laboratory tests', 'DIAGNOSTIC', 7),
    ('Medication adjustment', 'MEDICATION', 8),
    ('Nutritional counseling', 'CONSULTATION', 9),
    ('Physiotherapy exercises', 'THERAPY', 10);
