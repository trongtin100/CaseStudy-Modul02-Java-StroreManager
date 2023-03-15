public class Table {
    private String tableID;
    private TableType tableType;
    private double surchargeTable;
    private boolean status;

    public Table(String tableID, TableType tableType, Boolean status) {
        this.tableID = tableID;
        this.tableType = tableType;
        
        this.status = status;
    }

    
    public void setSurchargeTable(Integer surchargeTable) {this.surchargeTable = surchargeTable;}

    public String getTableID() {return tableID;}
    public void setTableID(String tableID) {this.tableID = tableID;}

    public TableType getTableType() {return tableType;}
    public void setTableType(TableType tableType) {this.tableType = tableType;}

    public boolean isStatus() {return status;}
    public void setStatus(boolean status) {this.status = status;}

    @Override
    public String toString() {
        return "Table [tableID=" + tableID + ", tableType=" + tableType + ", status=" + status + "]";
    }

   

    
}
