public class ConstructionCost {

    private static final int stdMaterialCost = 1200;
    private static final int aboveStdMaterialCost = 1500;
    private static final int highStdMaterialCost = 1800;
    private static final int highStdFullyAutoCost = 2500;

    private static String[] materials = new String[]{"StdMaterial", "AboveStdMaterial", "HighStdMaterial"};

    public static String constructionCost(String selectedMaterial, float area, boolean FullyAutomated ) {
        if (area == 0)
            throw new RuntimeException();

        else if(selectedMaterial.equalsIgnoreCase(materials[0]))
            return String.format("%.2f", area*stdMaterialCost);

        else if(selectedMaterial.equalsIgnoreCase(materials[1]))
            return String.format("%.2f", area*aboveStdMaterialCost);

        else if (selectedMaterial.equalsIgnoreCase(materials[2]))
        {
            if (FullyAutomated)
                return String.format("%.2f", area*highStdFullyAutoCost);
            else
            	return String.format("%.2f", area*highStdMaterialCost);
        }
        else
            throw new RuntimeException();
    }

    public static String[] get() {
        return materials;
    }

}

