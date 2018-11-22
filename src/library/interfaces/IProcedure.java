package library.interfaces;

public interface IProcedure 
{
    public final String INSERT_CLIENT_PROCEDURE ="{call insertClient(?,?,?,?,?,?)}";
    public final String IS_CLIENT_FUNCTION = "{? = call isClient(?,?)}";
    public final String IS_BRANCH_MANAGER_FUNCTION = "{? = call isBranchManager(?,?)}";
    public final String IS_MAIN_MANAGER_FUNCTION = "{? = call isGeneralManager(?,?)}";
    
}