package com.mycompany.app.repository.jdbc;

import java.sql.Connection;

public interface DataSource {
    Connection createConnection();
}
