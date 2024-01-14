# Pizza Configurator

This is a simple Spring Boot application for a Pizza Configurator.

## Features

- Choose dough type (White, Whole Grain 30%, Whole Grain 60%, Gluten-Free)
- Choose sauce type (Tomato, Creme Fraiche, None)
- Select toppings (Salami, Mushroom, Ham, Spinach, Artichoke, Salmon, Doner, Garlic)
- Choose cheese topping (Gouda, Mozzarella, None)

## Usage

1. Start the application.
2. Open your browser and go to [http://localhost:8080/selectIngredients](http://localhost:8080/selectIngredients).
3. Follow the prompts to configure your pizza.
4. View the configuration and confirm your order.

## Notes

- Prices are calculated based on selected ingredients.
- Some combinations may not be allowed (e.g., Gluten-Free with White sauce).
- Enjoy your customized pizza!




# Read Me First

The following was discovered as part of building this project:

* No Docker Compose services found. As of now, the application won't start! Please add at least one service to
  the `compose.yaml` file.

# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.1/maven-plugin/reference/html/#build-image)
* [Docker Compose Support](https://docs.spring.io/spring-boot/docs/3.2.1/reference/htmlsingle/index.html#features.docker-compose)

### Docker Compose support

This project contains a Docker Compose file named `compose.yaml`.

However, no services were found. As of now, the application won't start!

Please make sure to add at least one service in the `compose.yaml` file.

