create table Account_ (
	mvccVersion bigint default 0,
	accountId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	parentAccountId bigint,
	name varchar(75) null,
	legalName varchar(75) null,
	legalId varchar(75) null,
	legalType varchar(75) null,
	sicCode varchar(75) null,
	tickerSymbol varchar(75) null,
	industry varchar(75) null,
	type_ varchar(75) null,
	size_ varchar(75) null
);

create table Address (
	mvccVersion bigint default 0,
	uuid_ varchar(75) null,
	addressId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	classNameId bigint,
	classPK bigint,
	street1 varchar(75) null,
	street2 varchar(75) null,
	street3 varchar(75) null,
	city varchar(75) null,
	zip varchar(75) null,
	regionId bigint,
	countryId bigint,
	typeId bigint,
	mailing bit,
	primary_ bit
);

create table AnnouncementsDelivery (
	deliveryId bigint not null primary key,
	companyId bigint,
	userId bigint,
	type_ varchar(75) null,
	email bit,
	sms bit,
	website bit
);

create table AnnouncementsEntry (
	uuid_ varchar(75) null,
	entryId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	classNameId bigint,
	classPK bigint,
	title varchar(75) null,
	content longvarchar null,
	url longvarchar null,
	type_ varchar(75) null,
	displayDate timestamp null,
	expirationDate timestamp null,
	priority int,
	alert bit
);

create table AnnouncementsFlag (
	flagId bigint not null primary key,
	userId bigint,
	createDate timestamp null,
	entryId bigint,
	value int
);

create table AssetCategory (
	uuid_ varchar(75) null,
	categoryId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	parentCategoryId bigint,
	leftCategoryId bigint,
	rightCategoryId bigint,
	name varchar(75) null,
	title longvarchar null,
	description longvarchar null,
	vocabularyId bigint
);

create table AssetCategoryProperty (
	categoryPropertyId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	categoryId bigint,
	key_ varchar(75) null,
	value varchar(75) null
);

create table AssetEntry (
	entryId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	classNameId bigint,
	classPK bigint,
	classUuid varchar(75) null,
	classTypeId bigint,
	listable bit,
	visible bit,
	startDate timestamp null,
	endDate timestamp null,
	publishDate timestamp null,
	expirationDate timestamp null,
	mimeType varchar(75) null,
	title longvarchar null,
	description longvarchar null,
	summary longvarchar null,
	url longvarchar null,
	layoutUuid varchar(75) null,
	height int,
	width int,
	priority double,
	viewCount int
);

create table AssetLink (
	linkId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	entryId1 bigint,
	entryId2 bigint,
	type_ int,
	weight int
);

create table AssetTag (
	tagId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	name varchar(75) null,
	assetCount int
);

create table AssetTagStats (
	tagStatsId bigint not null primary key,
	tagId bigint,
	classNameId bigint,
	assetCount int
);

create table AssetVocabulary (
	uuid_ varchar(75) null,
	vocabularyId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	name varchar(75) null,
	title longvarchar null,
	description longvarchar null,
	settings_ longvarchar null
);

create table BackgroundTask (
	mvccVersion bigint default 0,
	backgroundTaskId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	name varchar(255) null,
	servletContextNames varchar(255) null,
	taskExecutorClassName varchar(200) null,
	taskContextMap longvarchar null,
	completed bit,
	completionDate timestamp null,
	status int,
	statusMessage longvarchar null
);

create table BlogsEntry (
	uuid_ varchar(75) null,
	entryId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	title varchar(150) null,
	subtitle longvarchar null,
	urlTitle varchar(150) null,
	description longvarchar null,
	content longvarchar null,
	displayDate timestamp null,
	allowPingbacks bit,
	allowTrackbacks bit,
	trackbacks longvarchar null,
	coverImageFileEntryId bigint,
	coverImageURL varchar(75) null,
	smallImage bit,
	smallImageFileEntryId bigint,
	smallImageId bigint,
	smallImageURL longvarchar null,
	status int,
	statusByUserId bigint,
	statusByUserName varchar(75) null,
	statusDate timestamp null
);

create table BlogsStatsUser (
	statsUserId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	entryCount int,
	lastPostDate timestamp null,
	ratingsTotalEntries int,
	ratingsTotalScore double,
	ratingsAverageScore double
);

create table BrowserTracker (
	mvccVersion bigint default 0,
	browserTrackerId bigint not null primary key,
	userId bigint,
	browserKey bigint
);

create table CalEvent (
	uuid_ varchar(75) null,
	eventId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	title varchar(75) null,
	description longvarchar null,
	location longvarchar null,
	startDate timestamp null,
	endDate timestamp null,
	durationHour int,
	durationMinute int,
	allDay bit,
	timeZoneSensitive bit,
	type_ varchar(75) null,
	repeating bit,
	recurrence longvarchar null,
	remindBy int,
	firstReminder int,
	secondReminder int
);

create table ClassName_ (
	mvccVersion bigint default 0,
	classNameId bigint not null primary key,
	value varchar(200) null
);

create table ClusterGroup (
	mvccVersion bigint default 0,
	clusterGroupId bigint not null primary key,
	name varchar(75) null,
	clusterNodeIds varchar(75) null,
	wholeCluster bit
);

create table Company (
	mvccVersion bigint default 0,
	companyId bigint not null primary key,
	accountId bigint,
	webId varchar(75) null,
	key_ longvarchar null,
	mx varchar(75) null,
	homeURL longvarchar null,
	logoId bigint,
	system bit,
	maxUsers int,
	active_ bit
);

create table Contact_ (
	mvccVersion bigint default 0,
	contactId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	classNameId bigint,
	classPK bigint,
	accountId bigint,
	parentContactId bigint,
	emailAddress varchar(75) null,
	firstName varchar(75) null,
	middleName varchar(75) null,
	lastName varchar(75) null,
	prefixId bigint,
	suffixId bigint,
	male bit,
	birthday timestamp null,
	smsSn varchar(75) null,
	aimSn varchar(75) null,
	facebookSn varchar(75) null,
	icqSn varchar(75) null,
	jabberSn varchar(75) null,
	msnSn varchar(75) null,
	mySpaceSn varchar(75) null,
	skypeSn varchar(75) null,
	twitterSn varchar(75) null,
	ymSn varchar(75) null,
	employeeStatusId varchar(75) null,
	employeeNumber varchar(75) null,
	jobTitle varchar(100) null,
	jobClass varchar(75) null,
	hoursOfOperation varchar(75) null
);

create table Country (
	mvccVersion bigint default 0,
	countryId bigint not null primary key,
	name varchar(75) null,
	a2 varchar(75) null,
	a3 varchar(75) null,
	number_ varchar(75) null,
	idd_ varchar(75) null,
	zipRequired bit,
	active_ bit
);

create table DDLRecord (
	uuid_ varchar(75) null,
	recordId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	versionUserId bigint,
	versionUserName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	DDMStorageId bigint,
	recordSetId bigint,
	version varchar(75) null,
	displayIndex int
);

create table DDLRecordSet (
	uuid_ varchar(75) null,
	recordSetId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	DDMStructureId bigint,
	recordSetKey varchar(75) null,
	name longvarchar null,
	description longvarchar null,
	minDisplayRows int,
	scope int
);

create table DDLRecordVersion (
	recordVersionId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	DDMStorageId bigint,
	recordSetId bigint,
	recordId bigint,
	version varchar(75) null,
	displayIndex int,
	status int,
	statusByUserId bigint,
	statusByUserName varchar(75) null,
	statusDate timestamp null
);

create table DDMContent (
	uuid_ varchar(75) null,
	contentId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	name longvarchar null,
	description longvarchar null,
	data_ longvarchar null
);

create table DDMStorageLink (
	uuid_ varchar(75) null,
	storageLinkId bigint not null primary key,
	classNameId bigint,
	classPK bigint,
	structureId bigint
);

create table DDMStructure (
	uuid_ varchar(75) null,
	structureId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	parentStructureId bigint,
	classNameId bigint,
	structureKey varchar(75) null,
	version varchar(75) null,
	name longvarchar null,
	description longvarchar null,
	definition longvarchar null,
	storageType varchar(75) null,
	type_ int
);

create table DDMStructureLayout (
	uuid_ varchar(75) null,
	structureLayoutId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	structureVersionId bigint,
	definition longvarchar null
);

create table DDMStructureLink (
	structureLinkId bigint not null primary key,
	classNameId bigint,
	classPK bigint,
	structureId bigint
);

create table DDMStructureVersion (
	structureVersionId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	structureId bigint,
	version varchar(75) null,
	name longvarchar null,
	description longvarchar null,
	definition longvarchar null,
	storageType varchar(75) null,
	type_ int
);

create table DDMTemplate (
	uuid_ varchar(75) null,
	templateId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	classNameId bigint,
	classPK bigint,
	sourceClassNameId bigint,
	templateKey varchar(75) null,
	version varchar(75) null,
	name longvarchar null,
	description longvarchar null,
	type_ varchar(75) null,
	mode_ varchar(75) null,
	language varchar(75) null,
	script longvarchar null,
	cacheable bit,
	smallImage bit,
	smallImageId bigint,
	smallImageURL varchar(75) null
);

create table DDMTemplateVersion (
	templateVersionId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	templateId bigint,
	version varchar(75) null,
	name longvarchar null,
	description longvarchar null,
	language varchar(75) null,
	script longvarchar null
);

create table DLContent (
	contentId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	repositoryId bigint,
	path_ varchar(255) null,
	version varchar(75) null,
	data_ blob,
	size_ bigint
);

create table DLFileEntry (
	uuid_ varchar(75) null,
	fileEntryId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	classNameId bigint,
	classPK bigint,
	repositoryId bigint,
	folderId bigint,
	treePath longvarchar null,
	name varchar(255) null,
	fileName varchar(255) null,
	extension varchar(75) null,
	mimeType varchar(75) null,
	title varchar(255) null,
	description longvarchar null,
	extraSettings longvarchar null,
	fileEntryTypeId bigint,
	version varchar(75) null,
	size_ bigint,
	readCount int,
	smallImageId bigint,
	largeImageId bigint,
	custom1ImageId bigint,
	custom2ImageId bigint,
	manualCheckInRequired bit
);

create table DLFileEntryMetadata (
	uuid_ varchar(75) null,
	fileEntryMetadataId bigint not null primary key,
	DDMStorageId bigint,
	DDMStructureId bigint,
	fileEntryTypeId bigint,
	fileEntryId bigint,
	fileVersionId bigint
);

create table DLFileEntryType (
	uuid_ varchar(75) null,
	fileEntryTypeId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	fileEntryTypeKey varchar(75) null,
	name longvarchar null,
	description longvarchar null
);

create table DLFileRank (
	fileRankId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	createDate timestamp null,
	fileEntryId bigint,
	active_ bit
);

create table DLFileShortcut (
	uuid_ varchar(75) null,
	fileShortcutId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	repositoryId bigint,
	folderId bigint,
	toFileEntryId bigint,
	treePath longvarchar null,
	active_ bit,
	status int,
	statusByUserId bigint,
	statusByUserName varchar(75) null,
	statusDate timestamp null
);

create table DLFileVersion (
	uuid_ varchar(75) null,
	fileVersionId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	repositoryId bigint,
	folderId bigint,
	fileEntryId bigint,
	treePath longvarchar null,
	fileName varchar(255) null,
	extension varchar(75) null,
	mimeType varchar(75) null,
	title varchar(255) null,
	description longvarchar null,
	changeLog varchar(75) null,
	extraSettings longvarchar null,
	fileEntryTypeId bigint,
	version varchar(75) null,
	size_ bigint,
	checksum varchar(75) null,
	status int,
	statusByUserId bigint,
	statusByUserName varchar(75) null,
	statusDate timestamp null
);

create table DLFolder (
	uuid_ varchar(75) null,
	folderId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	repositoryId bigint,
	mountPoint bit,
	parentFolderId bigint,
	treePath longvarchar null,
	name varchar(255) null,
	description longvarchar null,
	lastPostDate timestamp null,
	defaultFileEntryTypeId bigint,
	hidden_ bit,
	restrictionType int,
	status int,
	statusByUserId bigint,
	statusByUserName varchar(75) null,
	statusDate timestamp null
);

create table DLSyncEvent (
	syncEventId bigint not null primary key,
	modifiedTime bigint,
	event varchar(75) null,
	type_ varchar(75) null,
	typePK bigint
);

create table EmailAddress (
	mvccVersion bigint default 0,
	uuid_ varchar(75) null,
	emailAddressId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	classNameId bigint,
	classPK bigint,
	address varchar(75) null,
	typeId bigint,
	primary_ bit
);

create table ExpandoColumn (
	columnId bigint not null primary key,
	companyId bigint,
	tableId bigint,
	name varchar(75) null,
	type_ int,
	defaultData longvarchar null,
	typeSettings longvarchar null
);

create table ExpandoRow (
	rowId_ bigint not null primary key,
	companyId bigint,
	modifiedDate timestamp null,
	tableId bigint,
	classPK bigint
);

create table ExpandoTable (
	tableId bigint not null primary key,
	companyId bigint,
	classNameId bigint,
	name varchar(75) null
);

create table ExpandoValue (
	valueId bigint not null primary key,
	companyId bigint,
	tableId bigint,
	columnId bigint,
	rowId_ bigint,
	classNameId bigint,
	classPK bigint,
	data_ longvarchar null
);

create table ExportImportConfiguration (
	mvccVersion bigint default 0,
	exportImportConfigurationId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	name varchar(75) null,
	description longvarchar null,
	type_ int,
	settings_ longvarchar null,
	status int,
	statusByUserId bigint,
	statusByUserName varchar(75) null,
	statusDate timestamp null
);

create table Group_ (
	mvccVersion bigint default 0,
	uuid_ varchar(75) null,
	groupId bigint not null primary key,
	companyId bigint,
	creatorUserId bigint,
	classNameId bigint,
	classPK bigint,
	parentGroupId bigint,
	liveGroupId bigint,
	treePath longvarchar null,
	groupKey varchar(150) null,
	name longvarchar null,
	description longvarchar null,
	type_ int,
	typeSettings longvarchar null,
	manualMembership bit,
	membershipRestriction int,
	friendlyURL varchar(255) null,
	site bit,
	remoteStagingGroupCount int,
	inheritContent bit,
	active_ bit
);

create table Image (
	mvccVersion bigint default 0,
	imageId bigint not null primary key,
	modifiedDate timestamp null,
	type_ varchar(75) null,
	height int,
	width int,
	size_ int
);

create table JournalArticle (
	uuid_ varchar(75) null,
	id_ bigint not null primary key,
	resourcePrimKey bigint,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	folderId bigint,
	classNameId bigint,
	classPK bigint,
	treePath longvarchar null,
	articleId varchar(75) null,
	version double,
	title longvarchar null,
	urlTitle varchar(150) null,
	description longvarchar null,
	content longvarchar null,
	DDMStructureKey varchar(75) null,
	DDMTemplateKey varchar(75) null,
	layoutUuid varchar(75) null,
	displayDate timestamp null,
	expirationDate timestamp null,
	reviewDate timestamp null,
	indexable bit,
	smallImage bit,
	smallImageId bigint,
	smallImageURL longvarchar null,
	status int,
	statusByUserId bigint,
	statusByUserName varchar(75) null,
	statusDate timestamp null
);

create table JournalArticleImage (
	articleImageId bigint not null primary key,
	groupId bigint,
	articleId varchar(75) null,
	version double,
	elInstanceId varchar(75) null,
	elName varchar(75) null,
	languageId varchar(75) null,
	tempImage bit
);

create table JournalArticleResource (
	uuid_ varchar(75) null,
	resourcePrimKey bigint not null primary key,
	groupId bigint,
	articleId varchar(75) null
);

create table JournalContentSearch (
	contentSearchId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	privateLayout bit,
	layoutId bigint,
	portletId varchar(200) null,
	articleId varchar(75) null
);

create table JournalFeed (
	uuid_ varchar(75) null,
	id_ bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	feedId varchar(75) null,
	name varchar(75) null,
	description longvarchar null,
	DDMStructureKey varchar(75) null,
	DDMTemplateKey varchar(75) null,
	DDMRendererTemplateKey varchar(75) null,
	delta int,
	orderByCol varchar(75) null,
	orderByType varchar(75) null,
	targetLayoutFriendlyUrl varchar(255) null,
	targetPortletId varchar(75) null,
	contentField varchar(75) null,
	feedFormat varchar(75) null,
	feedVersion double
);

create table JournalFolder (
	uuid_ varchar(75) null,
	folderId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	parentFolderId bigint,
	treePath longvarchar null,
	name varchar(100) null,
	description longvarchar null,
	restrictionType int,
	status int,
	statusByUserId bigint,
	statusByUserName varchar(75) null,
	statusDate timestamp null
);

create table Layout (
	mvccVersion bigint default 0,
	uuid_ varchar(75) null,
	plid bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	privateLayout bit,
	layoutId bigint,
	parentLayoutId bigint,
	name longvarchar null,
	title longvarchar null,
	description longvarchar null,
	keywords longvarchar null,
	robots longvarchar null,
	type_ varchar(75) null,
	typeSettings longvarchar null,
	hidden_ bit,
	friendlyURL varchar(255) null,
	iconImageId bigint,
	themeId varchar(75) null,
	colorSchemeId varchar(75) null,
	wapThemeId varchar(75) null,
	wapColorSchemeId varchar(75) null,
	css longvarchar null,
	priority int,
	layoutPrototypeUuid varchar(75) null,
	layoutPrototypeLinkEnabled bit,
	sourcePrototypeLayoutUuid varchar(75) null
);

create table LayoutBranch (
	mvccVersion bigint default 0,
	layoutBranchId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	layoutSetBranchId bigint,
	plid bigint,
	name varchar(75) null,
	description longvarchar null,
	master bit
);

create table LayoutFriendlyURL (
	mvccVersion bigint default 0,
	uuid_ varchar(75) null,
	layoutFriendlyURLId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	plid bigint,
	privateLayout bit,
	friendlyURL varchar(255) null,
	languageId varchar(75) null
);

create table LayoutPrototype (
	mvccVersion bigint default 0,
	uuid_ varchar(75) null,
	layoutPrototypeId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	name longvarchar null,
	description longvarchar null,
	settings_ longvarchar null,
	active_ bit
);

create table LayoutRevision (
	mvccVersion bigint default 0,
	layoutRevisionId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	layoutSetBranchId bigint,
	layoutBranchId bigint,
	parentLayoutRevisionId bigint,
	head bit,
	major bit,
	plid bigint,
	privateLayout bit,
	name longvarchar null,
	title longvarchar null,
	description longvarchar null,
	keywords longvarchar null,
	robots longvarchar null,
	typeSettings longvarchar null,
	iconImageId bigint,
	themeId varchar(75) null,
	colorSchemeId varchar(75) null,
	wapThemeId varchar(75) null,
	wapColorSchemeId varchar(75) null,
	css longvarchar null,
	status int,
	statusByUserId bigint,
	statusByUserName varchar(75) null,
	statusDate timestamp null
);

create table LayoutSet (
	mvccVersion bigint default 0,
	layoutSetId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	createDate timestamp null,
	modifiedDate timestamp null,
	privateLayout bit,
	logoId bigint,
	themeId varchar(75) null,
	colorSchemeId varchar(75) null,
	wapThemeId varchar(75) null,
	wapColorSchemeId varchar(75) null,
	css longvarchar null,
	pageCount int,
	settings_ longvarchar null,
	layoutSetPrototypeUuid varchar(75) null,
	layoutSetPrototypeLinkEnabled bit
);

create table LayoutSetBranch (
	mvccVersion bigint default 0,
	layoutSetBranchId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	privateLayout bit,
	name varchar(75) null,
	description longvarchar null,
	master bit,
	logoId bigint,
	themeId varchar(75) null,
	colorSchemeId varchar(75) null,
	wapThemeId varchar(75) null,
	wapColorSchemeId varchar(75) null,
	css longvarchar null,
	settings_ longvarchar null,
	layoutSetPrototypeUuid varchar(75) null,
	layoutSetPrototypeLinkEnabled bit
);

create table LayoutSetPrototype (
	mvccVersion bigint default 0,
	uuid_ varchar(75) null,
	layoutSetPrototypeId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	name longvarchar null,
	description longvarchar null,
	settings_ longvarchar null,
	active_ bit
);

create table ListType (
	mvccVersion bigint default 0,
	listTypeId bigint not null primary key,
	name varchar(75) null,
	type_ varchar(75) null
);

create table Lock_ (
	mvccVersion bigint default 0,
	uuid_ varchar(75) null,
	lockId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	className varchar(75) null,
	key_ varchar(200) null,
	owner varchar(1024) null,
	inheritable bit,
	expirationDate timestamp null
);

create table MBBan (
	uuid_ varchar(75) null,
	banId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	banUserId bigint
);

create table MBCategory (
	uuid_ varchar(75) null,
	categoryId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	parentCategoryId bigint,
	name varchar(75) null,
	description longvarchar null,
	displayStyle varchar(75) null,
	threadCount int,
	messageCount int,
	lastPostDate timestamp null,
	status int,
	statusByUserId bigint,
	statusByUserName varchar(75) null,
	statusDate timestamp null
);

create table MBDiscussion (
	uuid_ varchar(75) null,
	discussionId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	classNameId bigint,
	classPK bigint,
	threadId bigint
);

create table MBMailingList (
	uuid_ varchar(75) null,
	mailingListId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	categoryId bigint,
	emailAddress varchar(75) null,
	inProtocol varchar(75) null,
	inServerName varchar(75) null,
	inServerPort int,
	inUseSSL bit,
	inUserName varchar(75) null,
	inPassword varchar(75) null,
	inReadInterval int,
	outEmailAddress varchar(75) null,
	outCustom bit,
	outServerName varchar(75) null,
	outServerPort int,
	outUseSSL bit,
	outUserName varchar(75) null,
	outPassword varchar(75) null,
	allowAnonymous bit,
	active_ bit
);

create table MBMessage (
	uuid_ varchar(75) null,
	messageId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	classNameId bigint,
	classPK bigint,
	categoryId bigint,
	threadId bigint,
	rootMessageId bigint,
	parentMessageId bigint,
	subject varchar(75) null,
	body longvarchar null,
	format varchar(75) null,
	anonymous bit,
	priority double,
	allowPingbacks bit,
	answer bit,
	status int,
	statusByUserId bigint,
	statusByUserName varchar(75) null,
	statusDate timestamp null
);

create table MBStatsUser (
	statsUserId bigint not null primary key,
	groupId bigint,
	userId bigint,
	messageCount int,
	lastPostDate timestamp null
);

create table MBThread (
	uuid_ varchar(75) null,
	threadId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	categoryId bigint,
	rootMessageId bigint,
	rootMessageUserId bigint,
	messageCount int,
	viewCount int,
	lastPostByUserId bigint,
	lastPostDate timestamp null,
	priority double,
	question bit,
	status int,
	statusByUserId bigint,
	statusByUserName varchar(75) null,
	statusDate timestamp null
);

create table MBThreadFlag (
	uuid_ varchar(75) null,
	threadFlagId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	threadId bigint
);

create table MDRAction (
	uuid_ varchar(75) null,
	actionId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	classNameId bigint,
	classPK bigint,
	ruleGroupInstanceId bigint,
	name longvarchar null,
	description longvarchar null,
	type_ varchar(255) null,
	typeSettings longvarchar null
);

create table MDRRule (
	uuid_ varchar(75) null,
	ruleId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	ruleGroupId bigint,
	name longvarchar null,
	description longvarchar null,
	type_ varchar(255) null,
	typeSettings longvarchar null
);

create table MDRRuleGroup (
	uuid_ varchar(75) null,
	ruleGroupId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	name longvarchar null,
	description longvarchar null
);

create table MDRRuleGroupInstance (
	uuid_ varchar(75) null,
	ruleGroupInstanceId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	classNameId bigint,
	classPK bigint,
	ruleGroupId bigint,
	priority int
);

create table MembershipRequest (
	mvccVersion bigint default 0,
	membershipRequestId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	createDate timestamp null,
	comments longvarchar null,
	replyComments longvarchar null,
	replyDate timestamp null,
	replierUserId bigint,
	statusId bigint
);

create table Organization_ (
	mvccVersion bigint default 0,
	uuid_ varchar(75) null,
	organizationId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	parentOrganizationId bigint,
	treePath longvarchar null,
	name varchar(100) null,
	type_ varchar(75) null,
	recursable bit,
	regionId bigint,
	countryId bigint,
	statusId bigint,
	comments longvarchar null,
	logoId bigint
);

create table OrgLabor (
	mvccVersion bigint default 0,
	orgLaborId bigint not null primary key,
	organizationId bigint,
	typeId bigint,
	sunOpen int,
	sunClose int,
	monOpen int,
	monClose int,
	tueOpen int,
	tueClose int,
	wedOpen int,
	wedClose int,
	thuOpen int,
	thuClose int,
	friOpen int,
	friClose int,
	satOpen int,
	satClose int
);

create table PasswordPolicy (
	mvccVersion bigint default 0,
	uuid_ varchar(75) null,
	passwordPolicyId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	defaultPolicy bit,
	name varchar(75) null,
	description longvarchar null,
	changeable bit,
	changeRequired bit,
	minAge bigint,
	checkSyntax bit,
	allowDictionaryWords bit,
	minAlphanumeric int,
	minLength int,
	minLowerCase int,
	minNumbers int,
	minSymbols int,
	minUpperCase int,
	regex varchar(75) null,
	history bit,
	historyCount int,
	expireable bit,
	maxAge bigint,
	warningTime bigint,
	graceLimit int,
	lockout bit,
	maxFailure int,
	lockoutDuration bigint,
	requireUnlock bit,
	resetFailureCount bigint,
	resetTicketMaxAge bigint
);

create table PasswordPolicyRel (
	mvccVersion bigint default 0,
	passwordPolicyRelId bigint not null primary key,
	passwordPolicyId bigint,
	classNameId bigint,
	classPK bigint
);

create table PasswordTracker (
	mvccVersion bigint default 0,
	passwordTrackerId bigint not null primary key,
	userId bigint,
	createDate timestamp null,
	password_ varchar(75) null
);

create table Phone (
	mvccVersion bigint default 0,
	uuid_ varchar(75) null,
	phoneId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	classNameId bigint,
	classPK bigint,
	number_ varchar(75) null,
	extension varchar(75) null,
	typeId bigint,
	primary_ bit
);

create table PluginSetting (
	mvccVersion bigint default 0,
	pluginSettingId bigint not null primary key,
	companyId bigint,
	pluginId varchar(75) null,
	pluginType varchar(75) null,
	roles longvarchar null,
	active_ bit
);

create table PortalPreferences (
	mvccVersion bigint default 0,
	portalPreferencesId bigint not null primary key,
	ownerId bigint,
	ownerType int,
	preferences longvarchar null
);

create table Portlet (
	mvccVersion bigint default 0,
	id_ bigint not null primary key,
	companyId bigint,
	portletId varchar(200) null,
	roles longvarchar null,
	active_ bit
);

create table PortletItem (
	mvccVersion bigint default 0,
	portletItemId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	name varchar(75) null,
	portletId varchar(200) null,
	classNameId bigint
);

create table PortletPreferences (
	mvccVersion bigint default 0,
	portletPreferencesId bigint not null primary key,
	ownerId bigint,
	ownerType int,
	plid bigint,
	portletId varchar(200) null,
	preferences longvarchar null
);

create table RatingsEntry (
	uuid_ varchar(75) null,
	entryId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	classNameId bigint,
	classPK bigint,
	score double
);

create table RatingsStats (
	statsId bigint not null primary key,
	classNameId bigint,
	classPK bigint,
	totalEntries int,
	totalScore double,
	averageScore double
);

create table Region (
	mvccVersion bigint default 0,
	regionId bigint not null primary key,
	countryId bigint,
	regionCode varchar(75) null,
	name varchar(75) null,
	active_ bit
);

create table Release_ (
	mvccVersion bigint default 0,
	releaseId bigint not null primary key,
	createDate timestamp null,
	modifiedDate timestamp null,
	servletContextName varchar(75) null,
	buildNumber int,
	buildDate timestamp null,
	verified bit,
	state_ int,
	testString varchar(1024) null
);

create table Repository (
	mvccVersion bigint default 0,
	uuid_ varchar(75) null,
	repositoryId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	classNameId bigint,
	name varchar(75) null,
	description longvarchar null,
	portletId varchar(200) null,
	typeSettings longvarchar null,
	dlFolderId bigint
);

create table RepositoryEntry (
	mvccVersion bigint default 0,
	uuid_ varchar(75) null,
	repositoryEntryId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	repositoryId bigint,
	mappedId varchar(255) null,
	manualCheckInRequired bit
);

create table ResourceAction (
	mvccVersion bigint default 0,
	resourceActionId bigint not null primary key,
	name varchar(255) null,
	actionId varchar(75) null,
	bitwiseValue bigint
);

create table ResourceBlock (
	mvccVersion bigint default 0,
	resourceBlockId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	name varchar(75) null,
	permissionsHash varchar(75) null,
	referenceCount bigint
);

create table ResourceBlockPermission (
	mvccVersion bigint default 0,
	resourceBlockPermissionId bigint not null primary key,
	resourceBlockId bigint,
	roleId bigint,
	actionIds bigint
);

create table ResourcePermission (
	mvccVersion bigint default 0,
	resourcePermissionId bigint not null primary key,
	companyId bigint,
	name varchar(255) null,
	scope int,
	primKey varchar(255) null,
	roleId bigint,
	ownerId bigint,
	actionIds bigint
);

create table ResourceTypePermission (
	mvccVersion bigint default 0,
	resourceTypePermissionId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	name varchar(75) null,
	roleId bigint,
	actionIds bigint
);

create table Role_ (
	mvccVersion bigint default 0,
	uuid_ varchar(75) null,
	roleId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	classNameId bigint,
	classPK bigint,
	name varchar(75) null,
	title longvarchar null,
	description longvarchar null,
	type_ int,
	subtype varchar(75) null
);

create table SCFrameworkVersion (
	frameworkVersionId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	name varchar(75) null,
	url longvarchar null,
	active_ bit,
	priority int
);

create table SCLicense (
	licenseId bigint not null primary key,
	name varchar(75) null,
	url longvarchar null,
	openSource bit,
	active_ bit,
	recommended bit
);

create table SCProductEntry (
	productEntryId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	name varchar(75) null,
	type_ varchar(75) null,
	tags varchar(255) null,
	shortDescription longvarchar null,
	longDescription longvarchar null,
	pageURL longvarchar null,
	author varchar(75) null,
	repoGroupId varchar(75) null,
	repoArtifactId varchar(75) null
);

create table SCProductScreenshot (
	productScreenshotId bigint not null primary key,
	companyId bigint,
	groupId bigint,
	productEntryId bigint,
	thumbnailId bigint,
	fullImageId bigint,
	priority int
);

create table SCProductVersion (
	productVersionId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	productEntryId bigint,
	version varchar(75) null,
	changeLog longvarchar null,
	downloadPageURL longvarchar null,
	directDownloadURL varchar(2000) null,
	repoStoreArtifact bit
);

create table ServiceComponent (
	mvccVersion bigint default 0,
	serviceComponentId bigint not null primary key,
	buildNamespace varchar(75) null,
	buildNumber bigint,
	buildDate bigint,
	data_ longvarchar null
);

create table Shard (
	mvccVersion bigint default 0,
	shardId bigint not null primary key,
	classNameId bigint,
	classPK bigint,
	name varchar(75) null
);

create table ShoppingCart (
	cartId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	itemIds longvarchar null,
	couponCodes varchar(75) null,
	altShipping int,
	insure bit
);

create table ShoppingCategory (
	categoryId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	parentCategoryId bigint,
	name varchar(75) null,
	description longvarchar null
);

create table ShoppingCoupon (
	couponId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	code_ varchar(75) null,
	name varchar(75) null,
	description longvarchar null,
	startDate timestamp null,
	endDate timestamp null,
	active_ bit,
	limitCategories longvarchar null,
	limitSkus longvarchar null,
	minOrder double,
	discount double,
	discountType varchar(75) null
);

create table ShoppingItem (
	itemId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	categoryId bigint,
	sku varchar(75) null,
	name varchar(200) null,
	description longvarchar null,
	properties longvarchar null,
	fields_ bit,
	fieldsQuantities longvarchar null,
	minQuantity int,
	maxQuantity int,
	price double,
	discount double,
	taxable bit,
	shipping double,
	useShippingFormula bit,
	requiresShipping bit,
	stockQuantity int,
	featured_ bit,
	sale_ bit,
	smallImage bit,
	smallImageId bigint,
	smallImageURL longvarchar null,
	mediumImage bit,
	mediumImageId bigint,
	mediumImageURL longvarchar null,
	largeImage bit,
	largeImageId bigint,
	largeImageURL longvarchar null
);

create table ShoppingItemField (
	itemFieldId bigint not null primary key,
	itemId bigint,
	name varchar(75) null,
	values_ longvarchar null,
	description longvarchar null
);

create table ShoppingItemPrice (
	itemPriceId bigint not null primary key,
	itemId bigint,
	minQuantity int,
	maxQuantity int,
	price double,
	discount double,
	taxable bit,
	shipping double,
	useShippingFormula bit,
	status int
);

create table ShoppingOrder (
	orderId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	number_ varchar(75) null,
	tax double,
	shipping double,
	altShipping varchar(75) null,
	requiresShipping bit,
	insure bit,
	insurance double,
	couponCodes varchar(75) null,
	couponDiscount double,
	billingFirstName varchar(75) null,
	billingLastName varchar(75) null,
	billingEmailAddress varchar(75) null,
	billingCompany varchar(75) null,
	billingStreet varchar(75) null,
	billingCity varchar(75) null,
	billingState varchar(75) null,
	billingZip varchar(75) null,
	billingCountry varchar(75) null,
	billingPhone varchar(75) null,
	shipToBilling bit,
	shippingFirstName varchar(75) null,
	shippingLastName varchar(75) null,
	shippingEmailAddress varchar(75) null,
	shippingCompany varchar(75) null,
	shippingStreet varchar(75) null,
	shippingCity varchar(75) null,
	shippingState varchar(75) null,
	shippingZip varchar(75) null,
	shippingCountry varchar(75) null,
	shippingPhone varchar(75) null,
	ccName varchar(75) null,
	ccType varchar(75) null,
	ccNumber varchar(75) null,
	ccExpMonth int,
	ccExpYear int,
	ccVerNumber varchar(75) null,
	comments longvarchar null,
	ppTxnId varchar(75) null,
	ppPaymentStatus varchar(75) null,
	ppPaymentGross double,
	ppReceiverEmail varchar(75) null,
	ppPayerEmail varchar(75) null,
	sendOrderEmail bit,
	sendShippingEmail bit
);

create table ShoppingOrderItem (
	orderItemId bigint not null primary key,
	orderId bigint,
	itemId longvarchar null,
	sku varchar(75) null,
	name varchar(200) null,
	description longvarchar null,
	properties longvarchar null,
	price double,
	quantity int,
	shippedDate timestamp null
);

create table SocialActivity (
	activityId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	createDate bigint,
	activitySetId bigint,
	mirrorActivityId bigint,
	classNameId bigint,
	classPK bigint,
	parentClassNameId bigint,
	parentClassPK bigint,
	type_ int,
	extraData longvarchar null,
	receiverUserId bigint
);

create table SocialActivityAchievement (
	activityAchievementId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	createDate bigint,
	name varchar(75) null,
	firstInGroup bit
);

create table SocialActivityCounter (
	activityCounterId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	classNameId bigint,
	classPK bigint,
	name varchar(75) null,
	ownerType int,
	currentValue int,
	totalValue int,
	graceValue int,
	startPeriod int,
	endPeriod int,
	active_ bit
);

create table SocialActivityLimit (
	activityLimitId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	classNameId bigint,
	classPK bigint,
	activityType int,
	activityCounterName varchar(75) null,
	value varchar(75) null
);

create table SocialActivitySet (
	activitySetId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	createDate bigint,
	modifiedDate bigint,
	classNameId bigint,
	classPK bigint,
	type_ int,
	extraData longvarchar null,
	activityCount int
);

create table SocialActivitySetting (
	activitySettingId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	classNameId bigint,
	activityType int,
	name varchar(75) null,
	value varchar(1024) null
);

create table SocialRelation (
	uuid_ varchar(75) null,
	relationId bigint not null primary key,
	companyId bigint,
	createDate bigint,
	userId1 bigint,
	userId2 bigint,
	type_ int
);

create table SocialRequest (
	uuid_ varchar(75) null,
	requestId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	createDate bigint,
	modifiedDate bigint,
	classNameId bigint,
	classPK bigint,
	type_ int,
	extraData longvarchar null,
	receiverUserId bigint,
	status int
);

create table Subscription (
	mvccVersion bigint default 0,
	subscriptionId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	classNameId bigint,
	classPK bigint,
	frequency varchar(75) null
);

create table SystemEvent (
	mvccVersion bigint default 0,
	systemEventId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	classNameId bigint,
	classPK bigint,
	classUuid varchar(75) null,
	referrerClassNameId bigint,
	parentSystemEventId bigint,
	systemEventSetKey bigint,
	type_ int,
	extraData longvarchar null
);

create table Team (
	mvccVersion bigint default 0,
	teamId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	groupId bigint,
	name varchar(75) null,
	description longvarchar null
);

create table Ticket (
	mvccVersion bigint default 0,
	ticketId bigint not null primary key,
	companyId bigint,
	createDate timestamp null,
	classNameId bigint,
	classPK bigint,
	key_ varchar(75) null,
	type_ int,
	extraInfo longvarchar null,
	expirationDate timestamp null
);

create table TrashEntry (
	entryId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	classNameId bigint,
	classPK bigint,
	systemEventSetKey bigint,
	typeSettings longvarchar null,
	status int
);

create table TrashVersion (
	versionId bigint not null primary key,
	entryId bigint,
	classNameId bigint,
	classPK bigint,
	typeSettings longvarchar null,
	status int
);

create table UserNotificationDelivery (
	mvccVersion bigint default 0,
	userNotificationDeliveryId bigint not null primary key,
	companyId bigint,
	userId bigint,
	portletId varchar(200) null,
	classNameId bigint,
	notificationType int,
	deliveryType int,
	deliver bit
);

create table User_ (
	mvccVersion bigint default 0,
	uuid_ varchar(75) null,
	userId bigint not null primary key,
	companyId bigint,
	createDate timestamp null,
	modifiedDate timestamp null,
	defaultUser bit,
	contactId bigint,
	password_ varchar(75) null,
	passwordEncrypted bit,
	passwordReset bit,
	passwordModifiedDate timestamp null,
	digest varchar(255) null,
	reminderQueryQuestion varchar(75) null,
	reminderQueryAnswer varchar(75) null,
	graceLoginCount int,
	screenName varchar(75) null,
	emailAddress varchar(75) null,
	facebookId bigint,
	ldapServerId bigint,
	openId varchar(1024) null,
	portraitId bigint,
	languageId varchar(75) null,
	timeZoneId varchar(75) null,
	greeting varchar(255) null,
	comments longvarchar null,
	firstName varchar(75) null,
	middleName varchar(75) null,
	lastName varchar(75) null,
	jobTitle varchar(100) null,
	loginDate timestamp null,
	loginIP varchar(75) null,
	lastLoginDate timestamp null,
	lastLoginIP varchar(75) null,
	lastFailedLoginDate timestamp null,
	failedLoginAttempts int,
	lockout bit,
	lockoutDate timestamp null,
	agreedToTermsOfUse bit,
	emailAddressVerified bit,
	status int
);

create table UserGroup (
	mvccVersion bigint default 0,
	uuid_ varchar(75) null,
	userGroupId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	parentUserGroupId bigint,
	name varchar(75) null,
	description longvarchar null,
	addedByLDAPImport bit
);

create table UserIdMapper (
	mvccVersion bigint default 0,
	userIdMapperId bigint not null primary key,
	userId bigint,
	type_ varchar(75) null,
	description varchar(75) null,
	externalUserId varchar(75) null
);

create table UserNotificationEvent (
	mvccVersion bigint default 0,
	uuid_ varchar(75) null,
	userNotificationEventId bigint not null primary key,
	companyId bigint,
	userId bigint,
	type_ varchar(75) null,
	timestamp bigint,
	deliveryType int,
	deliverBy bigint,
	delivered bit,
	payload longvarchar null,
	actionRequired bit,
	archived bit
);

create table UserTracker (
	mvccVersion bigint default 0,
	userTrackerId bigint not null primary key,
	companyId bigint,
	userId bigint,
	modifiedDate timestamp null,
	sessionId varchar(200) null,
	remoteAddr varchar(75) null,
	remoteHost varchar(75) null,
	userAgent varchar(200) null
);

create table UserTrackerPath (
	mvccVersion bigint default 0,
	userTrackerPathId bigint not null primary key,
	userTrackerId bigint,
	path_ longvarchar null,
	pathDate timestamp null
);

create table VirtualHost (
	mvccVersion bigint default 0,
	virtualHostId bigint not null primary key,
	companyId bigint,
	layoutSetId bigint,
	hostname varchar(75) null
);

create table WebDAVProps (
	mvccVersion bigint default 0,
	webDavPropsId bigint not null primary key,
	companyId bigint,
	createDate timestamp null,
	modifiedDate timestamp null,
	classNameId bigint,
	classPK bigint,
	props longvarchar null
);

create table Website (
	mvccVersion bigint default 0,
	uuid_ varchar(75) null,
	websiteId bigint not null primary key,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	classNameId bigint,
	classPK bigint,
	url longvarchar null,
	typeId bigint,
	primary_ bit
);

create table WorkflowDefinitionLink (
	mvccVersion bigint default 0,
	workflowDefinitionLinkId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	classNameId bigint,
	classPK bigint,
	typePK bigint,
	workflowDefinitionName varchar(75) null,
	workflowDefinitionVersion int
);

create table WorkflowInstanceLink (
	mvccVersion bigint default 0,
	workflowInstanceLinkId bigint not null primary key,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	classNameId bigint,
	classPK bigint,
	workflowInstanceId bigint
);
