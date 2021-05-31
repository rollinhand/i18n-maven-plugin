package com.benasmussen.maven.plugin.i18n.io;

/**
 * Supported output formats of the plugin.
 *
 * @author matemeszaros
 *         2015.10.26.
 */
public enum OutputFormat
{
    PROPERTIES {
        @Override
        public ResourceWriter getWriter()
        {
            return new PropertiesResourceWriter();
        }
    },
    JSON {
        @Override
        public ResourceWriter getWriter()
        {
            return new JsonResourceWriter();
        }
    },
    XML {
        @Override
        public ResourceWriter getWriter()
        {
            return new XmlResourceWriter();
        }
    };

    public abstract ResourceWriter getWriter();
}
