package Test.__G;

import java.util.*;

class Result {

    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("ball");
        name.add("box");
        name.add("ball");
        name.add("ball");
        name.add("box");
        List<Integer> price = new ArrayList<>();
        price.add(5);
        price.add(2);
        price.add(2);
        price.add(2);
        price.add(2);
        List<Integer> weight = new ArrayList<>();
        weight.add(2);
        weight.add(5);
        weight.add(1);
        weight.add(2);
        weight.add(1);
        weight.add(1);
        weight.add(3);


    }

    /*
     * Complete the 'numDuplicates' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING_ARRAY name
     *  2. INTEGER_ARRAY price
     *  3. INTEGER_ARRAY weight
     */

    public static int numDuplicates(List<String> name, List<Integer> price, List<Integer> weight) {
        int size = 0;
        Set<Product> products = new HashSet<>();

        for (int i = 0; i < size; i++) {
            Product product = new Product()
                    .setName(name.get(i))
                    .setPrice(price.get(i))
                    .setWeight(weight.get(i));
            products.add(product);
        }
        System.out.println(size - products.size());
        return size - products.size();
    }

    public static class Product{

        private String name;
        private int price;
        private int weight;

        public String getName() {
            return name;
        }

        public Product setName(String name) {
            this.name = name;
            return this;
        }

        public int getPrice() {
            return price;
        }

        public Product setPrice(int price) {
            this.price = price;
            return this;
        }

        public int getWeight() {
            return weight;
        }

        public Product setWeight(int weight) {
            this.weight = weight;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Product product = (Product) o;
            return price == product.price &&
                    weight == product.weight &&
                    Objects.equals(name, product.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, price, weight);
        }
    }
}