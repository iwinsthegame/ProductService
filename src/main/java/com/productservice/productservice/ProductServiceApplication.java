package com.productservice.productservice;

//import com.productservice.productservice.inheritancerelations.singletable;
//import com.productservice.productservice.inheritancerelations.tableperclass.*;

import com.productservice.productservice.model.Product;
import com.productservice.productservice.repositories.CategoryRepository;
import com.productservice.productservice.repositories.PriceRepository;
import com.productservice.productservice.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@Transactional
public class ProductServiceApplication implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final PriceRepository priceRepository;

    public ProductServiceApplication(CategoryRepository categoryRepository,
                                     ProductRepository productRepository,
                                     PriceRepository priceRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
    }

//    private final PriceRepository priceRepository;
//    private final OrderRepository orderRepository;
//    private final CategoryRepository categoryRepository;
//    private final ProductRepository productRepository;
//
//    public ProductServiceApplication(PriceRepository priceRepository,
//                                     OrderRepository orderRepository,
//                                     CategoryRepository categoryRepository,
//                                     ProductRepository productRepository) {
//        this.priceRepository = priceRepository;
//        this.orderRepository = orderRepository;
//        this.categoryRepository = categoryRepository;
//        this.productRepository = productRepository;
//    }

//    private final MentorsRepository mentorsRepository;
//    private final StudentRepository studentRepository;
//    private final TasRepository tasRepository;
//
//    private final UsersRepository usersRepository;

//    public ProductServiceApplication(MentorsRepository mentorsRepository,
//                                     StudentRepository studentRepository,
//                                     TasRepository tasRepository,
//
//                                     UsersRepository usersRepository) {
//        this.mentorsRepository = mentorsRepository;
//        this.studentRepository = studentRepository;
//        this.tasRepository = tasRepository;
//
//        this.usersRepository = usersRepository;
//    }

//    private final CategoryRepository categoryRepository;
//    private final ProductRepository productRepository;
//
//    public ProductServiceApplication(CategoryRepository categoryRepository,
//                                     ProductRepository productRepository) {
//        this.categoryRepository = categoryRepository;
//        this.productRepository = productRepository;
//    }

//    private final MentorRepository mentorRepository;
//
//    private final StudentsRepository studentsRepository;
//    private final UserRepository userRepository;
//
////       ProductServiceApplication(@Qualifier("ms_mentorrepository") MentorRepository mentorRepository){
////           this.mentorRepository =mentorRepository;
////       }
//
//    ProductServiceApplication(@Qualifier("tpc_mentorrepository") MentorRepository mentorRepository, StudentsRepository studentsRepository, UserRepository userRepository) {
//        this.mentorRepository = mentorRepository;
//        this.studentsRepository = studentsRepository;
//        this.userRepository = userRepository;
//    }

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //ms_mappedsuperclass
//        Mentor mentor = new Mentor();
//        mentor.setAvgRating(9.87);
//        mentor.setEmail("ravikumar21987@gmail.com");
//        mentor.setName("Ravi");
//
//        mentorRepository.save(mentor);
        // doing for tableper claass
        //com.productservice.productservice.inheritancerelations.tableperclass.Mentor mentor1 = new com.productservice.productservice.inheritancerelations.tableperclass.Mentor();
//ms_tableperclass
//        Mentor mentor = new Mentor();
//        mentor.setAvgRating(7.87);
//        mentor.setEmail("youavikumar21987@gmail.com");
//        mentor.setName("mehak");
//
//        mentorRepository.save(mentor);
//
//        Student student = new Student();
//        student.setName("halala");
//        student.setEmail("bolojai@scaler.com");
//        student.setPsp(99.45);
//
//        studentsRepository.save(student);
//
//        User user = new User();
//        user.setEmail("kahonapyaar@scaler.com");
//        user.setName("Hum hai n");
//
//        userRepository.save(user);
//
//
//        //get all the user
//        List<User> users = userRepository.findAll();
//        for(User user1 : users){
//            System.out.println(user1.toString());
//        }


//        Mentor mentor = new Mentor();
//        mentor.setAvgRating(98.9);
//        mentorsRepository.save(mentor);
//
//        Student student = new Student();
//        student.setPsp(99.9);
//
//        studentRepository.save(student);
//
//       Ta ta = new Ta();
//        ta.setTa_session("kar lo acche se kaam");
//        tasRepository.save(ta);
//
//        User user = new User();
//        user.setEmail("naam@scaler.com");
//        user.setName("pradhanmantri");
//        usersRepository.save(user);

//        Category category = new Category();
//        category.setName("Apple device");
//
//        Category savedcategory = categoryRepository.save(category);

        //i can add multiple product of same category
        //not saying to add multiple category of same product
        //lets try to do it

//        Optional<Category> optionalcategory = categoryRepository.findById(UUID.fromString("aa22b2ae-9dbc-4271-aaca-eb5b1693cf9c"));
//
//        if (optionalcategory.isEmpty()) {
//            throw new Exception("category was null");
//        }
//
//        Category category = optionalcategory.get();


//        Product product = new Product();
//        product.setTitle("iphone 16");
//        product.setDescription("best iphone ever");
//        product.setCategory(category.get());
//
//        Product productSaved = productRepository.save(product);

        //find all the products with category = apple device

//        List<Product> products = category.getProducts();//internally it make sql query
//
//        for (Product product : products) {
//            System.out.println(product.getTitle());
//        }


//        Price price = new Price();
//        price.setCurrency("INR");
//        price.setValue(100000);
//       // Price savePrice = priceRepository.save(price);
//
//        Category category = new Category();
//        category.setName("Apple devices");
//        Category savedCategory = categoryRepository.save(category);
//
//
//        Product product = new Product();
//        product.setTitle("iphone 15 pro");
//        product.setDescription("Best iphone errrrr");
//        product.setCategory(savedCategory);
//        product.setPrice(price);
//
//       Product savedProduct = productRepository.save(product);

    //   productRepository.deleteById(UUID.fromString("9b8af599-5ce1-455a-8374-a125e3a2b09b"));

        //delete
//        Optional<Price> OptionalPrice = priceRepository.findById(UUID.fromString("3f6fc4f8-2d57-4f9a-9f1d-36a1a1c04ef2"));
//        if(OptionalPrice.isEmpty()){
//            throw  new Exception("Price is Empty");
//        }
//
//        Price price = OptionalPrice.get();
        //now want to delete the price , should it be allowed ?
     //   priceRepository.deleteById(UUID.fromString("3f6fc4f8-2d57-4f9a-9f1d-36a1a1c04ef2"));
       //error got in console :  could not execute statement [Cannot delete or update a parent row: a foreign key constraint fails (`ravi_capstone`.`product`, CONSTRAINT `FK2l5ugesxirs8wp4iqcmji7g8m` FOREIGN KEY (`price_id`) REFERENCES `price` (`id`))] [delete from price where id=?]; SQL [delete from price where id=?]; constraint [null]


//        Order order = new Order();
//        orderRepository.save(order);





        // test the category product
//  Category category = new Category();
//  category.setName("AppleDevice");
//      Category  savedCategory = categoryRepository.save(category);
//
//      Price price = new Price();
//      price.setValue(1000);
//      price.setCurrency("INR");


//      Optional<Price> optionalPrice =  priceRepository.findById(UUID.fromString("495a1609-d0be-4164-b7cb-b3a1be3b2583"));
//      if(optionalPrice.isEmpty()){
//          throw new Exception("Price object is nul");
//      }
//      Price price = optionalPrice.get();
//
//      Optional<Category>  optionalCategory = categoryRepository.findById(UUID.fromString("b08634be-e2f3-4e0e-a805-02c0ac4199c6"));
//      if(optionalCategory.isEmpty()){
//          throw new Exception("category object is null");
//      }
//
//      Category category = optionalCategory.get();


      // aor we can set direcly by using parameterized constructor
//      Product product1 = new Product();
//        product1.setPrice(price);
//        product1.setTitle("iphone hai bhai badhia wala");
//        product1.setDescription("Best iphone ever kehte thhe ");
//        product1.setImage("IMG1");
//        product1.setCategory(category);
//        productRepository.save(product1);
//
//       Product savedProduct = productRepository.save(product1);
//
//
//        Price price1 = new Price();
//        price1.setValue(11100);
//        price1.setCurrency("INR");

//        Product product2 = new Product();
//        product2.setPrice(price1);
//        product2.setTitle("iphone hai bhai le le");
//        product2.setDescription("keh do mujhe  iphone ever kehte thhe ");
//        product2.setImage("IMG2");
//        product2.setCategory(category);
//        productRepository.save(product2);
//
//        Product savedProduct2 = productRepository.save(product2);
//
//        Price price2 = new Price();
//        price2.setValue(9000);
//        price2.setCurrency("INR");

//        Product product3 = new Product();
//        product3.setPrice(price2);
//        product3.setTitle("iphone hai bhai mujhe bhi dilwa le");
//        product3.setDescription("keh do mujhe teri kadam p chume iphone ever kehte thhe ");
//        product3.setImage("IMG4");
//        product3.setCategory(category);
//        productRepository.save(product3);
//
//        Product savedProduct3 = productRepository.save(product3);

//        Optional<Category> optionalCategory = categoryRepository.findById(UUID.fromString("60a9a490-dff4-40fa-9953-4789f127ec33"));
//        Category category = optionalCategory.get();
//
//        List<Product> products = category.getProducts();
//
//        for(Product product : products ){
//            System.out.println(product.getTitle());
//        }

        //---------using parametrized constructor putting the value in product
        //-----as we get the transient instance must be saved before cuurent object wala error ..
        // .so for tht before we need to intaialize the objet of category than Price and then put the saved
        // value in the proiduct constructor


//        Category category = new Category();
//        category.setName("smsng");
//          Category savedCategory = categoryRepository.save(category);
//
//        Price price = new Price();
//        price.setCurrency("INR");
//        price.setValue(366666);
//
//        Price savedPrice = priceRepository.save(price);
//
//
//        //Product product = new Product("Samsung fold", "foldable hai" , "RRR", new Category("smsng",new ArrayList<>()),new Price("INR",3333));
//        Product product = new Product("Samsung fold", "foldable hai" , "RRR", savedCategory,savedPrice);
//
//        productRepository.save(product);


        //  *************************************************

        // List<Product> products = productRepository.findAll();

        // List<Product> products = productRepository.findAllByTitle("iphone hai bhai le le");

        // List<Product> products = productRepository.findAllByTitleAndDescription("iphone hai bhai le le","keh do mujhe  iphone ever kehte thhe ");

        //List<Product> products = productRepository.findAllByPrice_ValueGreaterThan(9000);

       // List<Product> products = productRepository.findAllByPrice_ValueLessThan(9000);

     //  List<Product> products = productRepository.findAllByPrice_ValueBetween(5000,10000);
    }
}
