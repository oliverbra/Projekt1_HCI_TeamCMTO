package com.thkoeln.hct.backend.common;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class OwnPhysicalNamingStrategy implements PhysicalNamingStrategy {


    @Override
    public Identifier toPhysicalCatalogName(final Identifier identifier, final JdbcEnvironment jdbcEnv) {
        return identifier;
    }

    @Override
    public Identifier toPhysicalColumnName(final Identifier identifier, final JdbcEnvironment jdbcEnv) {
        return convertColumnName(identifier);
    }

    @Override
    public Identifier toPhysicalSchemaName(final Identifier identifier, final JdbcEnvironment jdbcEnv) {
        return identifier;
    }

    @Override
    public Identifier toPhysicalSequenceName(final Identifier identifier, final JdbcEnvironment jdbcEnv) {
        return identifier;
    }

    @Override
    public Identifier toPhysicalTableName(final Identifier identifier, final JdbcEnvironment jdbcEnv) {
        return convertTableName(identifier);
    }

    private Identifier convertColumnName(final Identifier identifier) {

        String newName = convertName(identifier);
        return Identifier.toIdentifier(newName);
    }

    private Identifier convertTableName(final Identifier identifier) {

        String newName = convertName(identifier);
        return Identifier.toIdentifier(newName);
    }

    private String convertName(Identifier identifier) {
        String regex = "([a-z])([A-Z])";
        String replacement = "$1_$2";
        return identifier.getText()
                .replaceAll(regex, replacement)
                .toUpperCase();
    }
}