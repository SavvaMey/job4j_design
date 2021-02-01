package lsp;

import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ControllQualityTest {

    @Test
    public void executeStrategyTrash() {
        Calendar dateCreated = Calendar.getInstance();
        Calendar dateExpired = Calendar.getInstance();
        dateCreated.set(2021, Calendar.JANUARY, 10);
        dateExpired.set(2021, Calendar.JANUARY, 20);
        Food milk = new Milk("milk", dateCreated, dateExpired, 1000, 0);
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        ControllQuality control = new ControllQuality(List.of(shop, trash, warehouse));
        control.distribute(milk);
        assertThat(milk.getName(), is(trash.getStore().get(0).getName()));
    }

    @Test
    public void executeStrategyWarehouse() {
        Calendar dateCreated = Calendar.getInstance();
        Calendar dateExpired = Calendar.getInstance();
        dateCreated.set(2021, Calendar.JANUARY, 30);
        dateExpired.set(2021, Calendar.FEBRUARY, 30);
        Food bread = new Bread("bread", dateCreated, dateExpired, 100, 0);
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        ControllQuality control = new ControllQuality(List.of(shop, trash, warehouse));
        control.distribute(bread);
        assertThat(bread.getName(), is(warehouse.getStore().get(0).getName()));
    }

    @Test
    public void executeStrategyShopNoDiscount() {
        Calendar dateCreated = Calendar.getInstance();
        Calendar dateExpired = Calendar.getInstance();
        dateCreated.set(2021, Calendar.JANUARY, 15);
        dateExpired.set(2021, Calendar.FEBRUARY, 15);
        Food bread = new Bread("bread", dateCreated, dateExpired, 100, 0);
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        ControllQuality control = new ControllQuality(List.of(shop, trash, warehouse));
        control.distribute(bread);
        assertThat(bread.getName(), is(shop.getStore().get(0).getName()));
    }

    @Test
    public void executeStrategyShopDiscount() {
        Calendar dateCreated = Calendar.getInstance();
        Calendar dateExpired = Calendar.getInstance();
        dateCreated.set(2021, Calendar.JANUARY, 15);
        dateExpired.set(2021, Calendar.FEBRUARY, 2);
        Food bread = new Bread("bread", dateCreated, dateExpired, 100, 0);
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        ControllQuality control = new ControllQuality(List.of(shop, trash, warehouse));
        control.distribute(bread);
        assertThat(75, is(shop.getStore().get(0).getPrice()));
    }

    @Test
    public void executeClear() {
        Calendar dateCreated = Calendar.getInstance();
        Calendar dateExpired = Calendar.getInstance();
        dateCreated.set(2021, Calendar.JANUARY, 15);
        dateExpired.set(2021, Calendar.FEBRUARY, 2);
        Food bread = new Bread("bread", dateCreated, dateExpired, 100, 0);
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        ControllQuality control = new ControllQuality(List.of(shop, trash, warehouse));
        control.distribute(bread);
        shop.clear();
        assertThat(0, is(shop.getStore().size()));
    }
}