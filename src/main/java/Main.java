import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class Main extends Application<MainConfiguration> {
  public static void main(String[] args) throws Exception {
    new Main().run(args);
  }

  @Override
  public void run(MainConfiguration configuration, Environment environment) {
    environment.jersey().register(new Resource());
  }
}