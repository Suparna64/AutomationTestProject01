package com.appsenseca.categories;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;

/**
 * Created by Suparna Das on 4/1/2017.
 */

@RunWith(Categories.class)
@Categories.IncludeCategory({Critical.class})
public interface Critical {


}
