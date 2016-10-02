package com.symsystem.optitime.common;

/**
 * @author sym
 */

public abstract class AbstractId {

    private final String id;

    protected AbstractId(String id) {
        this.id = id;
    }

    public final String id() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractId abstractId = (AbstractId) obj;
        return id.equals(abstractId.id);
    }

    @Override
    public String toString() {
        return String.format("%s : id=%s", getClass().getSimpleName(), id);
    }
}
