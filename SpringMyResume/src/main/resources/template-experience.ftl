<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link href="http://fonts.googleapis.com/css?family=Arvo" rel="stylesheet" type="text/css" />
        <link href="http://fonts.googleapis.com/css?family=Lobster" rel="stylesheet" type="text/css" />
        <link href="../css/style.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.js"></script>
        <script type="text/javascript" src="../js/script.js" ></script> 
<title>Resume of ${name}</title>
</head>
<body>
<div id="bg">
	<div id="outer">
	<#if objective??>
		<div id="objective">
			${objective}
		</div>
	</#if>
	<div id="header">
		<div id="logo">
			<h1>
				<a href="#">${name?capitalize}</a>
			</h1>
		</div>
		<div id="nav">
			<ul>
			<#list menu as menuitem>
				<li>
				<#if menuitem.url??>
					<a href="${menuitem.url}">${menuitem.name}</a>
				</#if>
				</li>
			</#list>
			</ul>						
		</div>
	</div>
	<div id="main">
		<div id="sidebar">
			<ul class="linkedList">
			 <#list menu as menuitem>
				<li>
					<a href="${menuitem.url}">${menuitem.name}</a>
				</li>
			</#list>									
		</div>
		<div id="content">
			<div id="box1">
				<table id="experiencelist">
					
	   				<#list experiences as experience>
	   				<table id="experiencetable" title="Click to collapse table">
					<th>
							${experience.company}-(${experience.startDate} to ${experience.endDate}) :
					</th>
					<tr>
						<td>
							<h4>Project List:</h4>
						</td>
					</tr>
					<#if experience.projectList?has_content>
					  	<#assign projectList = experience.projectList>
						<#list projectList as project>
					
					<tr>
					<td>
					<table id="projecttable">
						
							<th>							
									${project_index+1}.${project.projectName !}
							</th>
							<tr>
								<td>
									Client: ${project.client.clientName !},${project.client.clientLocation !}
								</td>
							</tr>
							<tr>
								<td>
									Description:<br/>
									<p>
									${project.projectDescription.projectDescription !}
									</p>
								</td>
							</tr>
							<tr>
							<#if project.skillsUsed?has_content>
								<td>
									Skills Used:
								
									<#assign skillused = project.skillsUsed>
									<#list skillused as skill>
										<a href="skills.html">${skill.skillname !}</a>
									</#list>
								</td>
							</#if>
							</tr>
					</table>
					</td>
					</tr>
					
					</#list>
					</#if>
					<tr>
						<td>
							${experience.remarks!}
						</td>
					</tr>
					</table>
					</#list>				
				</table>
			</div>
		</div>
	</div>
	</div>
</div>
</body>
</html>