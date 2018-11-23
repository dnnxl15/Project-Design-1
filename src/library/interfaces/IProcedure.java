package library.interfaces;

public interface IProcedure 
{
    public final String INSERT_CLIENT_PROCEDURE ="{call insertClient(?,?,?,?,?,?)}";
    public final String IS_CLIENT_FUNCTION = "{? = call isClient(?,?)}";
    public final String IS_BRANCH_MANAGER_FUNCTION = "{? = call isBranchManager(?,?)}";
    public final String IS_MAIN_MANAGER_FUNCTION = "{? = call isGeneralManager(?,?)}";
    
    public final String INSERT_EMPLOYEE_PROCEDURE  = "{call insertEmployee(?,?,?,?,?,?)}";
    public final String INSERT_RESTAURANT_PROCEDURE  = "{call insertRestaurant(?,?)}";
    public final String INSERT_MANAGER_PROCEDURE  = "{call insertManager(?,?,?,?,?,?,?)}";
    
    public final String GET_RESTAURAN_PROCEDURE = "{call getRestaurant()}";
}