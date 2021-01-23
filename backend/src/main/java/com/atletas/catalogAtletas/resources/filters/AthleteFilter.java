package com.atletas.catalogAtletas.resources.filters;

/**
 * Filtro para busca paginada de atletas
 * 
 * @author viniciosarodrigues
 *
 */
public class AthleteFilter extends CustomFilter {

    private static final long serialVersionUID = 5424139323464989036L;

    private String id;
    private String name;
    private String codAthlete;
    private String idCategory;
    private String idModality;
    private String idSchool;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodAthlete() {
        return codAthlete;
    }

    public void setCodAthlete(String codAthlete) {
        this.codAthlete = codAthlete;
    }

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    public String getIdModality() {
        return idModality;
    }

    public void setIdModality(String idModality) {
        this.idModality = idModality;
    }

    public String getIdSchool() {
        return idSchool;
    }

    public void setIdSchool(String idSchool) {
        this.idSchool = idSchool;
    }

    public AthleteFilter() {
        super();
    }

    public AthleteFilter(Integer page, Integer size, String orderBy, String direction) {
        super(page, size, orderBy, direction);
    }

    public AthleteFilter(String id, String name, String codAthlete, String idCategory, String idModality, String idSchool) {
        super();
        this.id = id;
        this.name = name;
        this.codAthlete = codAthlete;
        this.idCategory = idCategory;
        this.idModality = idModality;
        this.idSchool = idSchool;
    }

}
