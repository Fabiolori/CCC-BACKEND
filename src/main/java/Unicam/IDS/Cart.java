package Unicam.IDS;

import javax.persistence.*;
import java.util.List;
@Entity
public class Cart {
//TODO 		@Column(name = "") per ogni parametro
		//IL CODICE UNIVOCO GENERATO DAI DATI PER IDENTIFICARLO
		@Id
		@GeneratedValue(strategy= GenerationType.AUTO)
		private int ID;
		
		//IL O I PRODOTTI CHE VENGONO AGGIUNTI NEL CARRELLO DAL CLIENTE, SE SI VUOLE METTERE PIU VOLTE LO STESSO PRODOTTO BISOGNA AGGIUNGERLO DI NUOVO NEL CARRELLO,
		//LA QUANTITà NON VIENE PRESA IN CONSIDERAZIONE NEL CARRELLO
		@ElementCollection(targetClass=Product.class)
		private List<Product>  products;
			
		//L'IMPORTO CHE IL CLIENTE HA PAGHERà, VIENE CREATO DALLA SOMMA DEI PREZZI DEI PRODOTTI NEL CARRELLO
		private int price;
		

		
		/* Costruisce un oggetto di tipo carrello
		 * 
		 * @param products 	
		 * 				i prodotti che vengono ordinati
		 * 
		 * 
		 */
		
		public Cart (List<Product>  products) {
			this.setID(products);
			this.setProducts(products);
			this.setPrice();
		}

		private void setID(List<Product> products) {
			// TODO Auto-generated method stub
			
		}

		/**
		 * @return the iD
		 */
		public int getID() {
			return ID;
		}

		/**
		 * @return the products
		 */
		public List<Product> getProducts() {
			return products;
		}

		/**
		 * @param products the products to set
		 */
		public void setProducts(List<Product> products) {
			this.products = products;
		}



		/**
		 * @return the price
		 */
		public int getPrice() {
			return price;
		}

		/**
		 *@set the price
		 */
		
		public void setPrice() {
			int sumprice= 0;
			for (int i =0; i<products.size();i++) {
				sumprice += products.get(i).getPrice();			
			}
				
			
			this.price = sumprice;
		}
		
		/**
		 * @param product the product to add
		 */
		public void addProduct(Product product) {
			if (product == null) throw new NullPointerException("Something went wrong: invalid add paramater");
			this.products.add(product);
			return;
		}

		/**
		 * @param product the product to remove
		 */
		public void removeProduct(Product product) {
			if (product == null) throw new NullPointerException("Something went wrong: invalid remove paramater");
			this.products.remove(product);
			return;
		}

}


