package com.Storyweaver.Pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class ImagePage extends BasePage{
	public ImagePage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBys(@FindBy(xpath="//ul[@class='pb-list pb-list--inline']/li"))
	List<WebElement> Filters;
	@FindBys(@FindBy(xpath="//label[@class='pb-checkbox__label']"))
	List<WebElement> Filter_Options;
	@FindBy(id="filters-bar-sort-by")
	WebElement Sort_By;
	@FindBys(@FindBy(xpath="//select[@id='filters-bar-sort-by']/option"))
	List<WebElement> SortBy_Options;
	@FindBys(@FindBy(xpath="//h3[@class='pb-image-card__title']//a"))
	List<WebElement> Image_List;
	@FindBy(xpath="//div[@title='Refresh']")
	WebElement Load_More;
	
	public boolean is_Image_Page(String BaseURL){
		System.out.println(BaseURL+"illustrations?sort=Relevance");
		return driver.getCurrentUrl().equals(BaseURL+"illustrations?sort=Relevance");
		
	}
	
	public boolean filters_Count(){
		return Filters.size()==3;
	}
	
	public boolean Filters() throws InterruptedException{
		for(int i=0;i<Filters.size();i++){
			Thread.sleep(500);
			Filters.get(i).click();
			for(int j=0;j<Filter_Options.size();j++){
				Filters.get(i).isDisplayed();
				Filters.get(i).isEnabled();}
			Thread.sleep(500);
			Filters.get(i).click();}
		return true;
	}
	
	public boolean sort_By(){
		Sort_By.click();
		return SortBy_Options.size()==4;
	}
    
	public boolean images_Per_Page(){
		return Image_List.size()==24;
	}
	
	public boolean images_After_LoadMore(){
		Load_More.click();
		return Image_List.size()==48;
	}
	
	
}










