package com.springmyresume.sitemaker;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.springmyresume.resume.Resume;
import com.springmyresume.sitemaker.pagecreator.EducationPageMaker;
import com.springmyresume.sitemaker.pagecreator.ExperiencePageMaker;
import com.springmyresume.sitemaker.pagecreator.IndexPageMaker;
import com.springmyresume.sitemaker.pagecreator.MenuItem;
import com.springmyresume.sitemaker.pagecreator.PageMaker;
import com.springmyresume.sitemaker.pagecreator.PublicationsPageMaker;
import com.springmyresume.sitemaker.pagecreator.ReferencesPageMaker;
import com.springmyresume.sitemaker.pagecreator.SkillsPageMaker;

import freemarker.template.Template;

public class SimpleSiteBuilder implements SiteBuilder {

	Site site;

	Resume resume;

	String location;

	String fileName;
	
	

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public SimpleSiteBuilder(Resume resume) {
		super();
		this.site = new Site();
		this.resume = resume;
	}

	public void buildLocation() {
		String name=this.resume.getPersonalDetails().getEmailId();
		name=name.replace("@", "");
		name=name.replace(".", "");
		this.fileName = name;
		this.site.setLocation(this.fileName);
		this.location=this.fileName;
		System.out.println(location);
	}

	public void buildIndexPage() {
		PageMaker pagemaker = new IndexPageMaker();
		Template template;
		try {
			template = pagemaker.getTemplate("template.ftl");

			Map<String, Object> displaymap = pagemaker
					.getDisplayMap(this.resume);
			List<MenuItem> menu = pagemaker.getMenu(this.resume);
			// System.out.println(menu);
			Map<String, Object> root = pagemaker.getMap(menu, displaymap,
					this.resume);
			// System.out.println(root);

			pagemaker.writePage("index.html", template, root, this.location);

			this.site.setIndexPage(pagemaker);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void buildEducationPage() {
		PageMaker pagemaker = new EducationPageMaker();
		Template template;
		try {
			template = pagemaker.getTemplate("template-education.ftl");

			Map<String, Object> displaymap = pagemaker
					.getDisplayMap(this.resume);
			List<MenuItem> menu = pagemaker.getMenu(this.resume);
			// System.out.println(menu);
			Map<String, Object> root = pagemaker.getMap(menu, displaymap,
					this.resume);
			// System.out.println(root);
			
			pagemaker.writePage("education.html", template, root, location+"/html");
			this.site.setIndexPage(pagemaker);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void buildExperiencePage() {
		PageMaker pagemaker = new ExperiencePageMaker();
		Template template;
		try {
			template = pagemaker.getTemplate("template-experience.ftl");

			Map<String, Object> displaymap = pagemaker
					.getDisplayMap(this.resume);
			List<MenuItem> menu = pagemaker.getMenu(this.resume);
			// System.out.println(menu);
			Map<String, Object> root = pagemaker.getMap(menu, displaymap,
					this.resume);
			// System.out.println(root);
			
			pagemaker.writePage("experience.html", template, root, location+"/html");
			this.site.setIndexPage(pagemaker);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void buildSkillsPage() {
		PageMaker pagemaker = new SkillsPageMaker();
		Template template;
		try {
			template = pagemaker.getTemplate("template-skill.ftl");

			Map<String, Object> displaymap = pagemaker
					.getDisplayMap(this.resume);
			List<MenuItem> menu = pagemaker.getMenu(this.resume);
			// System.out.println(menu);
			Map<String, Object> root = pagemaker.getMap(menu, displaymap,
					this.resume);
			// System.out.println(root);
		
			pagemaker.writePage("skills.html", template, root, location+"/html");
			this.site.setIndexPage(pagemaker);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void buildReferencesPage() {
		if (this.resume.getReferences()!=null) {
			PageMaker pagemaker = new ReferencesPageMaker();
			Template template;
			try {
				template = pagemaker.getTemplate("template-references.ftl");

				Map<String, Object> displaymap = pagemaker
						.getDisplayMap(this.resume);
				List<MenuItem> menu = pagemaker.getMenu(this.resume);
				// System.out.println(menu);
				Map<String, Object> root = pagemaker.getMap(menu, displaymap,
						this.resume);
				// System.out.println(root);
				;
				pagemaker.writePage("references.html", template, root, location+"/html");
				this.site.setIndexPage(pagemaker);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void buildPublicationsPage() {
		if (this.resume.getPublications()!=null) {
			PageMaker pagemaker = new PublicationsPageMaker();
			Template template;
			try {
				template = pagemaker.getTemplate("template-publications.ftl");

				Map<String, Object> displaymap = pagemaker
						.getDisplayMap(this.resume);
				List<MenuItem> menu = pagemaker.getMenu(this.resume);
				// System.out.println(menu);
				Map<String, Object> root = pagemaker.getMap(menu, displaymap,
						this.resume);
				// System.out.println(root);
				
				pagemaker.writePage("publications.html", template, root,
						location+"/html");
				this.site.setIndexPage(pagemaker);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void buildCss() {
		try{
		Resource resource =new ClassPathResource("css");
		System.out.println("RESOURCE"+resource.getURL().toString());
		File cssSrcDir = resource.getFile();
		File cssDstDir = new File(location + "/" + "css");
		//FileUtils fileutil = new FileUtils();
		
		FileUtils.copyDirectory(cssSrcDir, cssDstDir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void buildJs() {
		try {
		Resource resource =new ClassPathResource("js");
		File cssSrcDir = resource.getFile();
		File cssDstDir = new File(location + "/" + "js");

		
			FileUtils.copyDirectory(cssSrcDir, cssDstDir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void createZip(String directoryPath, String zipPath)
			throws IOException {
		FileOutputStream fOut = null;
		BufferedOutputStream bOut = null;
		ZipArchiveOutputStream tOut = null;

		try {
			File zipFile=new File(zipPath);
			zipFile.getParentFile().mkdirs();
			fOut = new FileOutputStream(zipFile);
			
			bOut = new BufferedOutputStream(fOut);
			tOut = new ZipArchiveOutputStream(bOut);
			addFileToZip(tOut, directoryPath, "");
		} catch(IOException e){
		e.printStackTrace();
		}finally {
		
			tOut.finish();
			tOut.close();
			bOut.close();
			fOut.close();
		}
	}

	private static void addFileToZip(ZipArchiveOutputStream zOut, String path,
			String base) throws IOException {
		File f = new File(path);
		String entryName = base + f.getName();
		ZipArchiveEntry zipEntry = new ZipArchiveEntry(f, entryName);

		zOut.putArchiveEntry(zipEntry);

		if (f.isFile()) {
			FileInputStream fInputStream = null;
			try {
				fInputStream = new FileInputStream(f);
				IOUtils.copy(fInputStream, zOut);
				zOut.closeArchiveEntry();
			} finally {
				IOUtils.closeQuietly(fInputStream);
			}

		} else {
			zOut.closeArchiveEntry();
			File[] children = f.listFiles();

			if (children != null) {
				for (File child : children) {
					addFileToZip(zOut, child.getAbsolutePath(), entryName + "/");
				}
			}
		}
	}

	public void createZipSite() {

		 ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();  
	     
		    String serverRealPath = servletContext.getRealPath("/");
		    String serverContextPath = servletContext.getContextPath();
		    
		String destZip = serverRealPath+"/ZipSites/" + this.fileName;
		try {
			createZip(this.location, destZip);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

	public Site getSite()
	{
		return this.site;
	}
}
