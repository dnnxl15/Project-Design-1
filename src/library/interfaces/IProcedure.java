package library.interfaces;

public interface IProcedure 
{
    public final String INSERT_CLIENT_PROCEDURE ="{call insertClient(?,?,?,?,?,?)}";
    public final String IS_CLIENT_FUNCTION = "{? = call isClient(?,?)}";
    public final String IS_BRANCH_MANAGER_FUNCTION = "{? = call isBranchManager(?,?)}";
    public final String IS_MAIN_MANAGER_FUNCTION = "{? = call isGeneralManager(?,?)}";
    
    public final String INSERT_EMPLOYEE_PROCEDURE  = "{call insertEmployee(?,?,?,?,?,?,?)}";
    public final String INSERT_RESTAURANT_PROCEDURE  = "{call insertRestaurant(?,?)}";
    public final String INSERT_MANAGER_PROCEDURE  = "{call insertManager(?,?,?,?,?,?,?)}";
    public final String INSERT_COMBO_PROCEDURE  = "{call insertCombo(?,?,?,?)}";
    public final String INSERT_PRODUCT_PROCEDURE  = "{call  insertProduct(?,?,?,?)}";
   
    public final String GET_RESTAURAN_PROCEDURE = "{call getRestaurant()}";
    public final String GET_JOB_TITLE_PROCEDURE = "{call getJobTitle()}";
    
    public final String GET_PRODUCTS_PROCEDURE = "{call getAvailableProduct()}";
    public final String GET_COMBOS_PROCEDURE = "{call getAvailableCombo()}";
    
    public final String GET_ALL_PRODUCTS_PROCEDURE = "{call getAllProduct()}";
    public final String GET_ALL_COMBOS_PROCEDURE = "{call getAllCombo()}";
    
    
    public final String DISABLE_PRODUCTS_PROCEDURE = "{call disableProduct(?)}";
    public final String DISABLE_COMBO_PROCEDURE = "{call disableCombo(?)}";
    
    public final String ENABLE_PRODUCTS_PROCEDURE = "{call enableProduct(?)}";
    public final String ENABLE_COMBO_PROCEDURE = "{call enableCombo(?)}";
    
    public final String UPDATE_PRODUCTS_PROCEDURE = "{call updateProduct(?,?,?,?,?)}";
    public final String UPDATE_COMBO_PROCEDURE = "{call updateCombo(?,?,?,?,?)}";
    
    public final String GET_CLIENT_PROCEDURE = "{call getClient()}";
    public final String UPDATE_CLIENT_PROCEDURE  = "{call  updateClient(?,?,?,?,?,?)}";
    
    
    public final String GET_EMPLOYEE_PROCEDURE = "{call getEmployeeInfo()}";
    public final String UPDATE_EMPLOYEE_PROCEDURE = "{call updateEmployee(?,?,?,?,?,?)}";
    
    
    public final String INSERT_JOBTITLE_PROCEDURE  = "{call  insertJobTitle(?,?,?)}";
    public final String UPDATE_JOBTITLE_PROCEDURE  = "{call  updateJobTitle(?,?,?,?)}";
    
    public final String REPORT_PRODUCT_PROCEDURE  = "{call  getGainAllProducts()}";
    public final String REPORT_COMBO_PROCEDURE  = "{call  getGainAllCombos()}";
    
    
}