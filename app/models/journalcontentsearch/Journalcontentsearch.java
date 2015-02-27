
package models.journalcontentsearch;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import controllers.journalcontentsearch.JournalcontentsearchFormData;

import play.db.ebean.Model;

import play.data.format.Formats;
import play.data.validation.Constraints;

/**
 * @author Manuel de la Peña
 * @generated
 */
@Entity
public class Journalcontentsearch extends Model {

	// model attributes

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public long contentSearchId;

	public long groupId;

	public long companyId;

	public boolean privateLayout;

	public long layoutId;

	@Constraints.MaxLength(200)
	public String portletId;

	@Constraints.MaxLength(75)
	public String articleId;


	// model finder attribute

	public static Finder<Long,Journalcontentsearch> find = new Finder<Long,Journalcontentsearch>(
		Long.class, Journalcontentsearch.class
	);

	// getters and setters

	public long getContentSearchId() {
		return contentSearchId;
	}

	public void setContentSearchId(long contentSearchId) {
		this.contentSearchId = contentSearchId;
	}
	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public boolean getPrivateLayout() {
		return privateLayout;
	}

	public void setPrivateLayout(boolean privateLayout) {
		this.privateLayout = privateLayout;
	}
	public long getLayoutId() {
		return layoutId;
	}

	public void setLayoutId(long layoutId) {
		this.layoutId = layoutId;
	}
	public String getPortletId() {
		return portletId;
	}

	public void setPortletId(String portletId) {
		this.portletId = portletId;
	}
	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public Journalcontentsearch(){
	}

	// constructor using a formData

	public Journalcontentsearch(JournalcontentsearchFormData formData) {
		contentSearchId = Long.valueOf(formData.contentSearchId);
		groupId = Long.valueOf(formData.groupId);
		companyId = Long.valueOf(formData.companyId);
		privateLayout = Boolean.valueOf(formData.privateLayout);
		layoutId = Long.valueOf(formData.layoutId);
		portletId = formData.portletId;
		articleId = formData.articleId;
	}

	public JournalcontentsearchFormData toFormData() {
		if (contentSearchId < 0) {
			contentSearchId = 0L;
		}

		JournalcontentsearchFormData formData = new JournalcontentsearchFormData(
			String.valueOf(contentSearchId)
			,
			String.valueOf(groupId)
			,
			String.valueOf(companyId)
			,
			String.valueOf(privateLayout)
			,
			String.valueOf(layoutId)
			,
			portletId
			,
			articleId
			
		);

		return formData;
	}

}
