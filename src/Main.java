import java.util.*;

public class Main {
    public static void main(String... args) {
        Scanner scan = new Scanner(System.in);

        List<String> operations = new ArrayList<>(Arrays.asList("ADD", "SHOW", "DELETE", "SEARCH"));
        List<String> products = new ArrayList<>(Arrays.asList("Bread", "Apples", "Milk", "Milk pudding", "milkyway", "milkshake"));

        while (true) {
            System.out.println("Select next action");// предлагаем на выбор операцию
            String input = scan.nextLine();
            if ("end".equals(input)) {
                break;
            }

            int operation = Integer.parseInt(String.valueOf(input));
            switch (operation) {
                case 1:
                    System.out.println("Operation:" + operations.get(0));
                    System.out.println("What product do you want to add?");
                    String product = scan.nextLine();
                    products.add(product);
                    System.out.println("Total in the shopping list:" + products.size());
                    break;
                case 2:
                    System.out.println("Operation:" + operations.get(1));
                    System.out.println("Shopping list:");
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println((i + 1) + "." + products.get(i));
                    }
                    break;
                case 3:
                    System.out.println("Operation:" + operations.get(2));
                    System.out.println("Shopping list:");
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println((i + 1) + "." + products.get(i));
                    }
                    System.out.println("Which one do you want to delete? Enter the number or name");

                    String prod = scan.nextLine();
                    Iterator<String> iterator = products.iterator();

                    try {
                        int numbProduct = Integer.parseInt(prod);
                        String removedProd = products.get(numbProduct - 1);
                        products.remove(numbProduct - 1);
                        System.out.println("Product " + removedProd + " deleted, shopping list:");

                    } catch (NumberFormatException e) {
                        while (iterator.hasNext()) {
                            if (iterator.next().equals(prod)) {
                                iterator.remove();
                            }
                        }
                        System.out.println("Product " + prod + " deleted, shopping list:");
                    }

                    for (int i = 0; i < products.size(); i++) {
                        System.out.println((i + 1) + "." + products.get(i));
                    }
                    break;
                case 4:
                    System.out.println("Operation:" + operations.get(3));
                    System.out.println("Enter the search text: ");

                    String searchProd = scan.nextLine().toLowerCase();
                    System.out.println("Found: ");
                    List<String> searchResult = new ArrayList<>(List.of());

                    for (int i = 0; i < products.size(); i++) {
                        String currentProd = products.get(i).toLowerCase();
                        if (currentProd.contains(searchProd)) {
                            searchResult.add(products.get(i));
                        }

                    }
                    if (!searchResult.isEmpty()) {
                        for (String productResult :
                                searchResult) {
                            System.out.println(productResult);
                        }
                    }
                    break;
                default:
                    System.out.println("No such operation");

            }
        }
    }
}
