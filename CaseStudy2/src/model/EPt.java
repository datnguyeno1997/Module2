package model;

public enum EPt {
    KHÔNG(1,"Không"), CÓ_PT(2,"Có_Pt");
    private long id;
    private String name;

    EPt(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static EPt findByName(String name) {
        for (EPt e : EPt.values()) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return null;
    }
    public static EPt findById(int id) {
        for (EPt e : EPt.values()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
}
