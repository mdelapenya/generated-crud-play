# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table account (
  account_id                bigint not null,
  mvcc_version              bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  parent_account_id         bigint,
  name                      varchar(255),
  legal_name                varchar(255),
  legal_id                  varchar(255),
  legal_type                varchar(255),
  sic_code                  varchar(255),
  ticker_symbol             varchar(255),
  industry                  varchar(255),
  customtype                varchar(255),
  size                      varchar(255),
  constraint pk_account primary key (account_id))
;

create table address (
  address_id                bigint not null,
  mvcc_version              bigint,
  uuid                      varchar(255),
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  class_name_id             bigint,
  class_pk                  bigint,
  street1                   varchar(255),
  street2                   varchar(255),
  street3                   varchar(255),
  city                      varchar(255),
  zip                       varchar(255),
  region_id                 bigint,
  country_id                bigint,
  type_id                   bigint,
  mailing                   boolean,
  customprimary             boolean,
  constraint pk_address primary key (address_id))
;

create table announcementsdelivery (
  delivery_id               bigint not null,
  company_id                bigint,
  user_id                   bigint,
  customtype                varchar(255),
  email                     boolean,
  sms                       boolean,
  website                   boolean,
  constraint pk_announcementsdelivery primary key (delivery_id))
;

create table announcementsentry (
  entry_id                  bigint not null,
  uuid                      varchar(255),
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  class_name_id             bigint,
  class_pk                  bigint,
  title                     varchar(255),
  content                   varchar(255),
  url                       varchar(255),
  customtype                varchar(255),
  display_date              timestamp,
  expiration_date           timestamp,
  priority                  integer,
  alert                     boolean,
  constraint pk_announcementsentry primary key (entry_id))
;

create table announcementsflag (
  flag_id                   bigint not null,
  user_id                   bigint,
  create_date               timestamp,
  entry_id                  bigint,
  value                     integer,
  constraint pk_announcementsflag primary key (flag_id))
;

create table assetcategory (
  category_id               bigint not null,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  parent_category_id        bigint,
  left_category_id          bigint,
  right_category_id         bigint,
  name                      varchar(255),
  title                     varchar(255),
  description               varchar(255),
  vocabulary_id             bigint,
  constraint pk_assetcategory primary key (category_id))
;

create table assetcategoryproperty (
  category_property_id      bigint not null,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  category_id               bigint,
  key                       varchar(255),
  value                     varchar(255),
  constraint pk_assetcategoryproperty primary key (category_property_id))
;

create table assetentry (
  entry_id                  bigint not null,
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  class_name_id             bigint,
  class_pk                  bigint,
  class_uuid                varchar(255),
  class_type_id             bigint,
  listable                  boolean,
  visible                   boolean,
  start_date                timestamp,
  end_date                  timestamp,
  publish_date              timestamp,
  expiration_date           timestamp,
  mime_type                 varchar(255),
  title                     varchar(255),
  description               varchar(255),
  summary                   varchar(255),
  url                       varchar(255),
  layout_uuid               varchar(255),
  height                    integer,
  width                     integer,
  priority                  double,
  view_count                integer,
  constraint pk_assetentry primary key (entry_id))
;

create table assetlink (
  link_id                   bigint not null,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  entry_id1                 bigint,
  entry_id2                 bigint,
  customtype                integer,
  weight                    integer,
  constraint pk_assetlink primary key (link_id))
;

create table assettag (
  tag_id                    bigint not null,
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  name                      varchar(255),
  asset_count               integer,
  constraint pk_assettag primary key (tag_id))
;

create table assettagstats (
  tag_stats_id              bigint not null,
  tag_id                    bigint,
  class_name_id             bigint,
  asset_count               integer,
  constraint pk_assettagstats primary key (tag_stats_id))
;

create table assetvocabulary (
  vocabulary_id             bigint not null,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  name                      varchar(255),
  title                     varchar(255),
  description               varchar(255),
  settings                  varchar(255),
  constraint pk_assetvocabulary primary key (vocabulary_id))
;

create table backgroundtask (
  background_task_id        bigint not null,
  mvcc_version              bigint,
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  name                      varchar(255),
  servlet_context_names     varchar(255),
  task_executor_class_name  varchar(255),
  task_context_map          varchar(255),
  completed                 boolean,
  completion_date           timestamp,
  status                    integer,
  status_message            varchar(255),
  constraint pk_backgroundtask primary key (background_task_id))
;

create table blogsentry (
  entry_id                  bigint not null,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  title                     varchar(255),
  subtitle                  varchar(255),
  url_title                 varchar(255),
  description               varchar(255),
  content                   varchar(255),
  display_date              timestamp,
  allow_pingbacks           boolean,
  allow_trackbacks          boolean,
  trackbacks                varchar(255),
  cover_image_file_entry_id bigint,
  cover_image_url           varchar(255),
  small_image               boolean,
  small_image_file_entry_id bigint,
  small_image_id            bigint,
  small_image_url           varchar(255),
  status                    integer,
  status_by_user_id         bigint,
  status_by_user_name       varchar(255),
  status_date               timestamp,
  constraint pk_blogsentry primary key (entry_id))
;

create table blogsstatsuser (
  stats_user_id             bigint not null,
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  entry_count               integer,
  last_post_date            timestamp,
  ratings_total_entries     integer,
  ratings_total_score       double,
  ratings_average_score     double,
  constraint pk_blogsstatsuser primary key (stats_user_id))
;

create table browsertracker (
  browser_tracker_id        bigint not null,
  mvcc_version              bigint,
  user_id                   bigint,
  browser_key               bigint,
  constraint pk_browsertracker primary key (browser_tracker_id))
;

create table calevent (
  event_id                  bigint not null,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  title                     varchar(255),
  description               varchar(255),
  location                  varchar(255),
  start_date                timestamp,
  end_date                  timestamp,
  duration_hour             integer,
  duration_minute           integer,
  all_day                   boolean,
  time_zone_sensitive       boolean,
  customtype                varchar(255),
  repeating                 boolean,
  recurrence                varchar(255),
  remind_by                 integer,
  first_reminder            integer,
  second_reminder           integer,
  constraint pk_calevent primary key (event_id))
;

create table classname (
  class_name_id             bigint not null,
  mvcc_version              bigint,
  value                     varchar(255),
  constraint pk_classname primary key (class_name_id))
;

create table clustergroup (
  cluster_group_id          bigint not null,
  mvcc_version              bigint,
  name                      varchar(255),
  cluster_node_ids          varchar(255),
  whole_cluster             boolean,
  constraint pk_clustergroup primary key (cluster_group_id))
;

create table company (
  company_id                bigint not null,
  mvcc_version              bigint,
  account_id                bigint,
  web_id                    varchar(255),
  key                       varchar(255),
  mx                        varchar(255),
  home_url                  varchar(255),
  logo_id                   bigint,
  system                    boolean,
  max_users                 integer,
  active                    boolean,
  constraint pk_company primary key (company_id))
;

create table contact (
  contact_id                bigint not null,
  mvcc_version              bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  class_name_id             bigint,
  class_pk                  bigint,
  account_id                bigint,
  parent_contact_id         bigint,
  email_address             varchar(255),
  first_name                varchar(255),
  middle_name               varchar(255),
  last_name                 varchar(255),
  prefix_id                 bigint,
  suffix_id                 bigint,
  male                      boolean,
  birthday                  timestamp,
  sms_sn                    varchar(255),
  aim_sn                    varchar(255),
  facebook_sn               varchar(255),
  icq_sn                    varchar(255),
  jabber_sn                 varchar(255),
  msn_sn                    varchar(255),
  my_space_sn               varchar(255),
  skype_sn                  varchar(255),
  twitter_sn                varchar(255),
  ym_sn                     varchar(255),
  employee_status_id        varchar(255),
  employee_number           varchar(255),
  job_title                 varchar(255),
  job_class                 varchar(255),
  hours_of_operation        varchar(255),
  constraint pk_contact primary key (contact_id))
;

create table country (
  country_id                bigint not null,
  mvcc_version              bigint,
  name                      varchar(255),
  a2                        varchar(255),
  a3                        varchar(255),
  number                    varchar(255),
  idd                       varchar(255),
  zip_required              boolean,
  active                    boolean,
  constraint pk_country primary key (country_id))
;

create table customgroup (
  group_id                  bigint not null,
  mvcc_version              bigint,
  uuid                      varchar(255),
  company_id                bigint,
  creator_user_id           bigint,
  class_name_id             bigint,
  class_pk                  bigint,
  parent_group_id           bigint,
  live_group_id             bigint,
  tree_path                 varchar(255),
  group_key                 varchar(255),
  name                      varchar(255),
  description               varchar(255),
  customtype                integer,
  type_settings             varchar(255),
  manual_membership         boolean,
  membership_restriction    integer,
  friendly_url              varchar(255),
  site                      boolean,
  remote_staging_group_count integer,
  inherit_content           boolean,
  active                    boolean,
  constraint pk_customgroup primary key (group_id))
;

create table ddlrecord (
  record_id                 bigint not null,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  version_user_id           bigint,
  version_user_name         varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  ddmstorage_id             bigint,
  record_set_id             bigint,
  version                   varchar(255),
  display_index             integer,
  constraint pk_ddlrecord primary key (record_id))
;

create table ddlrecordset (
  record_set_id             bigint not null,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  ddmstructure_id           bigint,
  record_set_key            varchar(255),
  name                      varchar(255),
  description               varchar(255),
  min_display_rows          integer,
  scope                     integer,
  constraint pk_ddlrecordset primary key (record_set_id))
;

create table ddlrecordversion (
  record_version_id         bigint not null,
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  ddmstorage_id             bigint,
  record_set_id             bigint,
  record_id                 bigint,
  version                   varchar(255),
  display_index             integer,
  status                    integer,
  status_by_user_id         bigint,
  status_by_user_name       varchar(255),
  status_date               timestamp,
  constraint pk_ddlrecordversion primary key (record_version_id))
;

create table ddmcontent (
  content_id                bigint not null,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  name                      varchar(255),
  description               varchar(255),
  data                      varchar(255),
  constraint pk_ddmcontent primary key (content_id))
;

create table ddmstoragelink (
  storage_link_id           bigint not null,
  uuid                      varchar(255),
  class_name_id             bigint,
  class_pk                  bigint,
  structure_id              bigint,
  constraint pk_ddmstoragelink primary key (storage_link_id))
;

create table ddmstructure (
  structure_id              bigint not null,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  parent_structure_id       bigint,
  class_name_id             bigint,
  structure_key             varchar(255),
  version                   varchar(255),
  name                      varchar(255),
  description               varchar(255),
  definition                varchar(255),
  storage_type              varchar(255),
  customtype                integer,
  constraint pk_ddmstructure primary key (structure_id))
;

create table ddmstructurelayout (
  structure_layout_id       bigint not null,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  structure_version_id      bigint,
  definition                varchar(255),
  constraint pk_ddmstructurelayout primary key (structure_layout_id))
;

create table ddmstructurelink (
  structure_link_id         bigint not null,
  class_name_id             bigint,
  class_pk                  bigint,
  structure_id              bigint,
  constraint pk_ddmstructurelink primary key (structure_link_id))
;

create table ddmstructureversion (
  structure_version_id      bigint not null,
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  structure_id              bigint,
  version                   varchar(255),
  name                      varchar(255),
  description               varchar(255),
  definition                varchar(255),
  storage_type              varchar(255),
  customtype                integer,
  constraint pk_ddmstructureversion primary key (structure_version_id))
;

create table ddmtemplate (
  template_id               bigint not null,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  class_name_id             bigint,
  class_pk                  bigint,
  source_class_name_id      bigint,
  template_key              varchar(255),
  version                   varchar(255),
  name                      varchar(255),
  description               varchar(255),
  customtype                varchar(255),
  mode                      varchar(255),
  language                  varchar(255),
  script                    varchar(255),
  cacheable                 boolean,
  small_image               boolean,
  small_image_id            bigint,
  small_image_url           varchar(255),
  constraint pk_ddmtemplate primary key (template_id))
;

create table ddmtemplateversion (
  template_version_id       bigint not null,
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  template_id               bigint,
  version                   varchar(255),
  name                      varchar(255),
  description               varchar(255),
  language                  varchar(255),
  script                    varchar(255),
  constraint pk_ddmtemplateversion primary key (template_version_id))
;

create table dlcontent (
  content_id                bigint not null,
  group_id                  bigint,
  company_id                bigint,
  repository_id             bigint,
  path                      varchar(255),
  version                   varchar(255),
  constraint pk_dlcontent primary key (content_id))
;

create table dlfileentry (
  file_entry_id             bigint not null,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  class_name_id             bigint,
  class_pk                  bigint,
  repository_id             bigint,
  folder_id                 bigint,
  tree_path                 varchar(255),
  name                      varchar(255),
  file_name                 varchar(255),
  extension                 varchar(255),
  mime_type                 varchar(255),
  title                     varchar(255),
  description               varchar(255),
  extra_settings            varchar(255),
  file_entry_type_id        bigint,
  version                   varchar(255),
  size                      bigint,
  read_count                integer,
  small_image_id            bigint,
  large_image_id            bigint,
  custom1image_id           bigint,
  custom2image_id           bigint,
  manual_check_in_required  boolean,
  constraint pk_dlfileentry primary key (file_entry_id))
;

create table dlfileentrymetadata (
  file_entry_metadata_id    bigint not null,
  uuid                      varchar(255),
  ddmstorage_id             bigint,
  ddmstructure_id           bigint,
  file_entry_type_id        bigint,
  file_entry_id             bigint,
  file_version_id           bigint,
  constraint pk_dlfileentrymetadata primary key (file_entry_metadata_id))
;

create table dlfileentrytype (
  file_entry_type_id        bigint not null,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  file_entry_type_key       varchar(255),
  name                      varchar(255),
  description               varchar(255),
  constraint pk_dlfileentrytype primary key (file_entry_type_id))
;

create table dlfilerank (
  file_rank_id              bigint not null,
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  create_date               timestamp,
  file_entry_id             bigint,
  active                    boolean,
  constraint pk_dlfilerank primary key (file_rank_id))
;

create table dlfileshortcut (
  file_shortcut_id          bigint not null,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  repository_id             bigint,
  folder_id                 bigint,
  to_file_entry_id          bigint,
  tree_path                 varchar(255),
  active                    boolean,
  status                    integer,
  status_by_user_id         bigint,
  status_by_user_name       varchar(255),
  status_date               timestamp,
  constraint pk_dlfileshortcut primary key (file_shortcut_id))
;

create table dlfileversion (
  file_version_id           bigint not null,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  repository_id             bigint,
  folder_id                 bigint,
  file_entry_id             bigint,
  tree_path                 varchar(255),
  file_name                 varchar(255),
  extension                 varchar(255),
  mime_type                 varchar(255),
  title                     varchar(255),
  description               varchar(255),
  change_log                varchar(255),
  extra_settings            varchar(255),
  file_entry_type_id        bigint,
  version                   varchar(255),
  size                      bigint,
  checksum                  varchar(255),
  status                    integer,
  status_by_user_id         bigint,
  status_by_user_name       varchar(255),
  status_date               timestamp,
  constraint pk_dlfileversion primary key (file_version_id))
;

create table dlfolder (
  folder_id                 bigint not null,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  repository_id             bigint,
  mount_point               boolean,
  parent_folder_id          bigint,
  tree_path                 varchar(255),
  name                      varchar(255),
  description               varchar(255),
  last_post_date            timestamp,
  default_file_entry_type_id bigint,
  hidden                    boolean,
  restriction_type          integer,
  status                    integer,
  status_by_user_id         bigint,
  status_by_user_name       varchar(255),
  status_date               timestamp,
  constraint pk_dlfolder primary key (folder_id))
;

create table dlsyncevent (
  sync_event_id             bigint not null,
  modified_time             bigint,
  event                     varchar(255),
  customtype                varchar(255),
  type_pk                   bigint,
  constraint pk_dlsyncevent primary key (sync_event_id))
;

create table emailaddress (
  email_address_id          bigint not null,
  mvcc_version              bigint,
  uuid                      varchar(255),
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  class_name_id             bigint,
  class_pk                  bigint,
  address                   varchar(255),
  type_id                   bigint,
  customprimary             boolean,
  constraint pk_emailaddress primary key (email_address_id))
;

create table expandocolumn (
  column_id                 bigint not null,
  company_id                bigint,
  table_id                  bigint,
  name                      varchar(255),
  customtype                integer,
  default_data              varchar(255),
  type_settings             varchar(255),
  constraint pk_expandocolumn primary key (column_id))
;

create table expandorow (
  row_id                    bigint not null,
  company_id                bigint,
  modified_date             timestamp,
  table_id                  bigint,
  class_pk                  bigint,
  constraint pk_expandorow primary key (row_id))
;

create table expandotable (
  table_id                  bigint not null,
  company_id                bigint,
  class_name_id             bigint,
  name                      varchar(255),
  constraint pk_expandotable primary key (table_id))
;

create table expandovalue (
  value_id                  bigint not null,
  company_id                bigint,
  table_id                  bigint,
  column_id                 bigint,
  row_id                    bigint,
  class_name_id             bigint,
  class_pk                  bigint,
  data                      varchar(255),
  constraint pk_expandovalue primary key (value_id))
;

create table exportimportconfiguration (
  export_import_configuration_id bigint not null,
  mvcc_version              bigint,
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  name                      varchar(255),
  description               varchar(255),
  customtype                integer,
  settings                  varchar(255),
  status                    integer,
  status_by_user_id         bigint,
  status_by_user_name       varchar(255),
  status_date               timestamp,
  constraint pk_exportimportconfiguration primary key (export_import_configuration_id))
;

create table image (
  image_id                  bigint not null,
  mvcc_version              bigint,
  modified_date             timestamp,
  customtype                varchar(255),
  height                    integer,
  width                     integer,
  size                      integer,
  constraint pk_image primary key (image_id))
;

create table journalarticle (
  id                        bigint not null,
  uuid                      varchar(255),
  resource_prim_key         bigint,
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  folder_id                 bigint,
  class_name_id             bigint,
  class_pk                  bigint,
  tree_path                 varchar(255),
  article_id                varchar(255),
  version                   double,
  title                     varchar(255),
  url_title                 varchar(255),
  description               varchar(255),
  content                   varchar(255),
  ddmstructure_key          varchar(255),
  ddmtemplate_key           varchar(255),
  layout_uuid               varchar(255),
  display_date              timestamp,
  expiration_date           timestamp,
  review_date               timestamp,
  indexable                 boolean,
  small_image               boolean,
  small_image_id            bigint,
  small_image_url           varchar(255),
  status                    integer,
  status_by_user_id         bigint,
  status_by_user_name       varchar(255),
  status_date               timestamp,
  constraint pk_journalarticle primary key (id))
;

create table journalarticleimage (
  article_image_id          bigint not null,
  group_id                  bigint,
  article_id                varchar(255),
  version                   double,
  el_instance_id            varchar(255),
  el_name                   varchar(255),
  language_id               varchar(255),
  temp_image                boolean,
  constraint pk_journalarticleimage primary key (article_image_id))
;

create table journalarticleresource (
  resource_prim_key         bigint not null,
  uuid                      varchar(255),
  group_id                  bigint,
  article_id                varchar(255),
  constraint pk_journalarticleresource primary key (resource_prim_key))
;

create table journalcontentsearch (
  content_search_id         bigint not null,
  group_id                  bigint,
  company_id                bigint,
  private_layout            boolean,
  layout_id                 bigint,
  portlet_id                varchar(255),
  article_id                varchar(255),
  constraint pk_journalcontentsearch primary key (content_search_id))
;

create table journalfeed (
  id                        bigint not null,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  feed_id                   varchar(255),
  name                      varchar(255),
  description               varchar(255),
  ddmstructure_key          varchar(255),
  ddmtemplate_key           varchar(255),
  ddmrenderer_template_key  varchar(255),
  delta                     integer,
  order_by_col              varchar(255),
  order_by_type             varchar(255),
  target_layout_friendly_url varchar(255),
  target_portlet_id         varchar(255),
  content_field             varchar(255),
  feed_format               varchar(255),
  feed_version              double,
  constraint pk_journalfeed primary key (id))
;

create table journalfolder (
  folder_id                 bigint not null,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  parent_folder_id          bigint,
  tree_path                 varchar(255),
  name                      varchar(255),
  description               varchar(255),
  restriction_type          integer,
  status                    integer,
  status_by_user_id         bigint,
  status_by_user_name       varchar(255),
  status_date               timestamp,
  constraint pk_journalfolder primary key (folder_id))
;

create table layout (
  plid                      bigint not null,
  mvcc_version              bigint,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  private_layout            boolean,
  layout_id                 bigint,
  parent_layout_id          bigint,
  name                      varchar(255),
  title                     varchar(255),
  description               varchar(255),
  keywords                  varchar(255),
  robots                    varchar(255),
  customtype                varchar(255),
  type_settings             varchar(255),
  hidden                    boolean,
  friendly_url              varchar(255),
  icon_image_id             bigint,
  theme_id                  varchar(255),
  color_scheme_id           varchar(255),
  wap_theme_id              varchar(255),
  wap_color_scheme_id       varchar(255),
  css                       varchar(255),
  priority                  integer,
  layout_prototype_uuid     varchar(255),
  layout_prototype_link_enabled boolean,
  source_prototype_layout_uuid varchar(255),
  constraint pk_layout primary key (plid))
;

create table layoutbranch (
  layout_branch_id          bigint not null,
  mvcc_version              bigint,
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  layout_set_branch_id      bigint,
  plid                      bigint,
  name                      varchar(255),
  description               varchar(255),
  master                    boolean,
  constraint pk_layoutbranch primary key (layout_branch_id))
;

create table layoutfriendlyurl (
  layout_friendly_urlid     bigint not null,
  mvcc_version              bigint,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  plid                      bigint,
  private_layout            boolean,
  friendly_url              varchar(255),
  language_id               varchar(255),
  constraint pk_layoutfriendlyurl primary key (layout_friendly_urlid))
;

create table layoutprototype (
  layout_prototype_id       bigint not null,
  mvcc_version              bigint,
  uuid                      varchar(255),
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  name                      varchar(255),
  description               varchar(255),
  settings                  varchar(255),
  active                    boolean,
  constraint pk_layoutprototype primary key (layout_prototype_id))
;

create table layoutrevision (
  layout_revision_id        bigint not null,
  mvcc_version              bigint,
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  layout_set_branch_id      bigint,
  layout_branch_id          bigint,
  parent_layout_revision_id bigint,
  head                      boolean,
  major                     boolean,
  plid                      bigint,
  private_layout            boolean,
  name                      varchar(255),
  title                     varchar(255),
  description               varchar(255),
  keywords                  varchar(255),
  robots                    varchar(255),
  type_settings             varchar(255),
  icon_image_id             bigint,
  theme_id                  varchar(255),
  color_scheme_id           varchar(255),
  wap_theme_id              varchar(255),
  wap_color_scheme_id       varchar(255),
  css                       varchar(255),
  status                    integer,
  status_by_user_id         bigint,
  status_by_user_name       varchar(255),
  status_date               timestamp,
  constraint pk_layoutrevision primary key (layout_revision_id))
;

create table layoutset (
  layout_set_id             bigint not null,
  mvcc_version              bigint,
  group_id                  bigint,
  company_id                bigint,
  create_date               timestamp,
  modified_date             timestamp,
  private_layout            boolean,
  logo_id                   bigint,
  theme_id                  varchar(255),
  color_scheme_id           varchar(255),
  wap_theme_id              varchar(255),
  wap_color_scheme_id       varchar(255),
  css                       varchar(255),
  page_count                integer,
  settings                  varchar(255),
  layout_set_prototype_uuid varchar(255),
  layout_set_prototype_link_enabled boolean,
  constraint pk_layoutset primary key (layout_set_id))
;

create table layoutsetbranch (
  layout_set_branch_id      bigint not null,
  mvcc_version              bigint,
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  private_layout            boolean,
  name                      varchar(255),
  description               varchar(255),
  master                    boolean,
  logo_id                   bigint,
  theme_id                  varchar(255),
  color_scheme_id           varchar(255),
  wap_theme_id              varchar(255),
  wap_color_scheme_id       varchar(255),
  css                       varchar(255),
  settings                  varchar(255),
  layout_set_prototype_uuid varchar(255),
  layout_set_prototype_link_enabled boolean,
  constraint pk_layoutsetbranch primary key (layout_set_branch_id))
;

create table layoutsetprototype (
  layout_set_prototype_id   bigint not null,
  mvcc_version              bigint,
  uuid                      varchar(255),
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  name                      varchar(255),
  description               varchar(255),
  settings                  varchar(255),
  active                    boolean,
  constraint pk_layoutsetprototype primary key (layout_set_prototype_id))
;

create table listtype (
  list_type_id              bigint not null,
  mvcc_version              bigint,
  name                      varchar(255),
  customtype                varchar(255),
  constraint pk_listtype primary key (list_type_id))
;

create table lock (
  lock_id                   bigint not null,
  mvcc_version              bigint,
  uuid                      varchar(255),
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  class_name                varchar(255),
  key                       varchar(255),
  owner                     varchar(255),
  inheritable               boolean,
  expiration_date           timestamp,
  constraint pk_lock primary key (lock_id))
;

create table mbban (
  ban_id                    bigint not null,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  ban_user_id               bigint,
  constraint pk_mbban primary key (ban_id))
;

create table mbcategory (
  category_id               bigint not null,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  parent_category_id        bigint,
  name                      varchar(255),
  description               varchar(255),
  display_style             varchar(255),
  thread_count              integer,
  message_count             integer,
  last_post_date            timestamp,
  status                    integer,
  status_by_user_id         bigint,
  status_by_user_name       varchar(255),
  status_date               timestamp,
  constraint pk_mbcategory primary key (category_id))
;

create table mbdiscussion (
  discussion_id             bigint not null,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  class_name_id             bigint,
  class_pk                  bigint,
  thread_id                 bigint,
  constraint pk_mbdiscussion primary key (discussion_id))
;

create table mbmailinglist (
  mailing_list_id           bigint not null,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  category_id               bigint,
  email_address             varchar(255),
  in_protocol               varchar(255),
  in_server_name            varchar(255),
  in_server_port            integer,
  in_use_ssl                boolean,
  in_user_name              varchar(255),
  in_password               varchar(255),
  in_read_interval          integer,
  out_email_address         varchar(255),
  out_custom                boolean,
  out_server_name           varchar(255),
  out_server_port           integer,
  out_use_ssl               boolean,
  out_user_name             varchar(255),
  out_password              varchar(255),
  allow_anonymous           boolean,
  active                    boolean,
  constraint pk_mbmailinglist primary key (mailing_list_id))
;

create table mbmessage (
  message_id                bigint not null,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  class_name_id             bigint,
  class_pk                  bigint,
  category_id               bigint,
  thread_id                 bigint,
  root_message_id           bigint,
  parent_message_id         bigint,
  subject                   varchar(255),
  body                      varchar(255),
  format                    varchar(255),
  anonymous                 boolean,
  priority                  double,
  allow_pingbacks           boolean,
  answer                    boolean,
  status                    integer,
  status_by_user_id         bigint,
  status_by_user_name       varchar(255),
  status_date               timestamp,
  constraint pk_mbmessage primary key (message_id))
;

create table mbstatsuser (
  stats_user_id             bigint not null,
  group_id                  bigint,
  user_id                   bigint,
  message_count             integer,
  last_post_date            timestamp,
  constraint pk_mbstatsuser primary key (stats_user_id))
;

create table mbthread (
  thread_id                 bigint not null,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  category_id               bigint,
  root_message_id           bigint,
  root_message_user_id      bigint,
  message_count             integer,
  view_count                integer,
  last_post_by_user_id      bigint,
  last_post_date            timestamp,
  priority                  double,
  question                  boolean,
  status                    integer,
  status_by_user_id         bigint,
  status_by_user_name       varchar(255),
  status_date               timestamp,
  constraint pk_mbthread primary key (thread_id))
;

create table mbthreadflag (
  thread_flag_id            bigint not null,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  thread_id                 bigint,
  constraint pk_mbthreadflag primary key (thread_flag_id))
;

create table mdraction (
  action_id                 bigint not null,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  class_name_id             bigint,
  class_pk                  bigint,
  rule_group_instance_id    bigint,
  name                      varchar(255),
  description               varchar(255),
  customtype                varchar(255),
  type_settings             varchar(255),
  constraint pk_mdraction primary key (action_id))
;

create table mdrrule (
  rule_id                   bigint not null,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  rule_group_id             bigint,
  name                      varchar(255),
  description               varchar(255),
  customtype                varchar(255),
  type_settings             varchar(255),
  constraint pk_mdrrule primary key (rule_id))
;

create table mdrrulegroup (
  rule_group_id             bigint not null,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  name                      varchar(255),
  description               varchar(255),
  constraint pk_mdrrulegroup primary key (rule_group_id))
;

create table mdrrulegroupinstance (
  rule_group_instance_id    bigint not null,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  class_name_id             bigint,
  class_pk                  bigint,
  rule_group_id             bigint,
  priority                  integer,
  constraint pk_mdrrulegroupinstance primary key (rule_group_instance_id))
;

create table membershiprequest (
  membership_request_id     bigint not null,
  mvcc_version              bigint,
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  create_date               timestamp,
  comments                  varchar(255),
  reply_comments            varchar(255),
  reply_date                timestamp,
  replier_user_id           bigint,
  status_id                 bigint,
  constraint pk_membershiprequest primary key (membership_request_id))
;

create table organization (
  organization_id           bigint not null,
  mvcc_version              bigint,
  uuid                      varchar(255),
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  parent_organization_id    bigint,
  tree_path                 varchar(255),
  name                      varchar(255),
  customtype                varchar(255),
  recursable                boolean,
  region_id                 bigint,
  country_id                bigint,
  status_id                 bigint,
  comments                  varchar(255),
  logo_id                   bigint,
  constraint pk_organization primary key (organization_id))
;

create table orglabor (
  org_labor_id              bigint not null,
  mvcc_version              bigint,
  organization_id           bigint,
  type_id                   bigint,
  sun_open                  integer,
  sun_close                 integer,
  mon_open                  integer,
  mon_close                 integer,
  tue_open                  integer,
  tue_close                 integer,
  wed_open                  integer,
  wed_close                 integer,
  thu_open                  integer,
  thu_close                 integer,
  fri_open                  integer,
  fri_close                 integer,
  sat_open                  integer,
  sat_close                 integer,
  constraint pk_orglabor primary key (org_labor_id))
;

create table passwordpolicy (
  password_policy_id        bigint not null,
  mvcc_version              bigint,
  uuid                      varchar(255),
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  default_policy            boolean,
  name                      varchar(255),
  description               varchar(255),
  changeable                boolean,
  change_required           boolean,
  min_age                   bigint,
  check_syntax              boolean,
  allow_dictionary_words    boolean,
  min_alphanumeric          integer,
  min_length                integer,
  min_lower_case            integer,
  min_numbers               integer,
  min_symbols               integer,
  min_upper_case            integer,
  regex                     varchar(255),
  history                   boolean,
  history_count             integer,
  expireable                boolean,
  max_age                   bigint,
  warning_time              bigint,
  grace_limit               integer,
  lockout                   boolean,
  max_failure               integer,
  lockout_duration          bigint,
  require_unlock            boolean,
  reset_failure_count       bigint,
  reset_ticket_max_age      bigint,
  constraint pk_passwordpolicy primary key (password_policy_id))
;

create table passwordpolicyrel (
  password_policy_rel_id    bigint not null,
  mvcc_version              bigint,
  password_policy_id        bigint,
  class_name_id             bigint,
  class_pk                  bigint,
  constraint pk_passwordpolicyrel primary key (password_policy_rel_id))
;

create table passwordtracker (
  password_tracker_id       bigint not null,
  mvcc_version              bigint,
  user_id                   bigint,
  create_date               timestamp,
  password                  varchar(255),
  constraint pk_passwordtracker primary key (password_tracker_id))
;

create table phone (
  phone_id                  bigint not null,
  mvcc_version              bigint,
  uuid                      varchar(255),
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  class_name_id             bigint,
  class_pk                  bigint,
  number                    varchar(255),
  extension                 varchar(255),
  type_id                   bigint,
  customprimary             boolean,
  constraint pk_phone primary key (phone_id))
;

create table pluginsetting (
  plugin_setting_id         bigint not null,
  mvcc_version              bigint,
  company_id                bigint,
  plugin_id                 varchar(255),
  plugin_type               varchar(255),
  roles                     varchar(255),
  active                    boolean,
  constraint pk_pluginsetting primary key (plugin_setting_id))
;

create table portalpreferences (
  portal_preferences_id     bigint not null,
  mvcc_version              bigint,
  owner_id                  bigint,
  owner_type                integer,
  preferences               varchar(255),
  constraint pk_portalpreferences primary key (portal_preferences_id))
;

create table portlet (
  id                        bigint not null,
  mvcc_version              bigint,
  company_id                bigint,
  portlet_id                varchar(255),
  roles                     varchar(255),
  active                    boolean,
  constraint pk_portlet primary key (id))
;

create table portletitem (
  portlet_item_id           bigint not null,
  mvcc_version              bigint,
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  name                      varchar(255),
  portlet_id                varchar(255),
  class_name_id             bigint,
  constraint pk_portletitem primary key (portlet_item_id))
;

create table portletpreferences (
  portlet_preferences_id    bigint not null,
  mvcc_version              bigint,
  owner_id                  bigint,
  owner_type                integer,
  plid                      bigint,
  portlet_id                varchar(255),
  preferences               varchar(255),
  constraint pk_portletpreferences primary key (portlet_preferences_id))
;

create table ratingsentry (
  entry_id                  bigint not null,
  uuid                      varchar(255),
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  class_name_id             bigint,
  class_pk                  bigint,
  score                     double,
  constraint pk_ratingsentry primary key (entry_id))
;

create table ratingsstats (
  stats_id                  bigint not null,
  class_name_id             bigint,
  class_pk                  bigint,
  total_entries             integer,
  total_score               double,
  average_score             double,
  constraint pk_ratingsstats primary key (stats_id))
;

create table region (
  region_id                 bigint not null,
  mvcc_version              bigint,
  country_id                bigint,
  region_code               varchar(255),
  name                      varchar(255),
  active                    boolean,
  constraint pk_region primary key (region_id))
;

create table release (
  release_id                bigint not null,
  mvcc_version              bigint,
  create_date               timestamp,
  modified_date             timestamp,
  servlet_context_name      varchar(255),
  build_number              integer,
  build_date                timestamp,
  verified                  boolean,
  state                     integer,
  test_string               varchar(255),
  constraint pk_release primary key (release_id))
;

create table repository (
  repository_id             bigint not null,
  mvcc_version              bigint,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  class_name_id             bigint,
  name                      varchar(255),
  description               varchar(255),
  portlet_id                varchar(255),
  type_settings             varchar(255),
  dl_folder_id              bigint,
  constraint pk_repository primary key (repository_id))
;

create table repositoryentry (
  repository_entry_id       bigint not null,
  mvcc_version              bigint,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  repository_id             bigint,
  mapped_id                 varchar(255),
  manual_check_in_required  boolean,
  constraint pk_repositoryentry primary key (repository_entry_id))
;

create table resourceaction (
  resource_action_id        bigint not null,
  mvcc_version              bigint,
  name                      varchar(255),
  action_id                 varchar(255),
  bitwise_value             bigint,
  constraint pk_resourceaction primary key (resource_action_id))
;

create table resourceblock (
  resource_block_id         bigint not null,
  mvcc_version              bigint,
  company_id                bigint,
  group_id                  bigint,
  name                      varchar(255),
  permissions_hash          varchar(255),
  reference_count           bigint,
  constraint pk_resourceblock primary key (resource_block_id))
;

create table resourceblockpermission (
  resource_block_permission_id bigint not null,
  mvcc_version              bigint,
  resource_block_id         bigint,
  role_id                   bigint,
  action_ids                bigint,
  constraint pk_resourceblockpermission primary key (resource_block_permission_id))
;

create table resourcepermission (
  resource_permission_id    bigint not null,
  mvcc_version              bigint,
  company_id                bigint,
  name                      varchar(255),
  scope                     integer,
  prim_key                  varchar(255),
  role_id                   bigint,
  owner_id                  bigint,
  action_ids                bigint,
  constraint pk_resourcepermission primary key (resource_permission_id))
;

create table resourcetypepermission (
  resource_type_permission_id bigint not null,
  mvcc_version              bigint,
  company_id                bigint,
  group_id                  bigint,
  name                      varchar(255),
  role_id                   bigint,
  action_ids                bigint,
  constraint pk_resourcetypepermission primary key (resource_type_permission_id))
;

create table role (
  role_id                   bigint not null,
  mvcc_version              bigint,
  uuid                      varchar(255),
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  class_name_id             bigint,
  class_pk                  bigint,
  name                      varchar(255),
  title                     varchar(255),
  description               varchar(255),
  customtype                integer,
  subtype                   varchar(255),
  constraint pk_role primary key (role_id))
;

create table scframeworkversion (
  framework_version_id      bigint not null,
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  name                      varchar(255),
  url                       varchar(255),
  active                    boolean,
  priority                  integer,
  constraint pk_scframeworkversion primary key (framework_version_id))
;

create table sclicense (
  license_id                bigint not null,
  name                      varchar(255),
  url                       varchar(255),
  open_source               boolean,
  active                    boolean,
  recommended               boolean,
  constraint pk_sclicense primary key (license_id))
;

create table scproductentry (
  product_entry_id          bigint not null,
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  name                      varchar(255),
  customtype                varchar(255),
  tags                      varchar(255),
  short_description         varchar(255),
  long_description          varchar(255),
  page_url                  varchar(255),
  author                    varchar(255),
  repo_group_id             varchar(255),
  repo_artifact_id          varchar(255),
  constraint pk_scproductentry primary key (product_entry_id))
;

create table scproductscreenshot (
  product_screenshot_id     bigint not null,
  company_id                bigint,
  group_id                  bigint,
  product_entry_id          bigint,
  thumbnail_id              bigint,
  full_image_id             bigint,
  priority                  integer,
  constraint pk_scproductscreenshot primary key (product_screenshot_id))
;

create table scproductversion (
  product_version_id        bigint not null,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  product_entry_id          bigint,
  version                   varchar(255),
  change_log                varchar(255),
  download_page_url         varchar(255),
  direct_download_url       varchar(255),
  repo_store_artifact       boolean,
  constraint pk_scproductversion primary key (product_version_id))
;

create table servicecomponent (
  service_component_id      bigint not null,
  mvcc_version              bigint,
  build_namespace           varchar(255),
  build_number              bigint,
  build_date                bigint,
  data                      varchar(255),
  constraint pk_servicecomponent primary key (service_component_id))
;

create table shard (
  shard_id                  bigint not null,
  mvcc_version              bigint,
  class_name_id             bigint,
  class_pk                  bigint,
  name                      varchar(255),
  constraint pk_shard primary key (shard_id))
;

create table shoppingcart (
  cart_id                   bigint not null,
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  item_ids                  varchar(255),
  coupon_codes              varchar(255),
  alt_shipping              integer,
  insure                    boolean,
  constraint pk_shoppingcart primary key (cart_id))
;

create table shoppingcategory (
  category_id               bigint not null,
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  parent_category_id        bigint,
  name                      varchar(255),
  description               varchar(255),
  constraint pk_shoppingcategory primary key (category_id))
;

create table shoppingcoupon (
  coupon_id                 bigint not null,
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  code                      varchar(255),
  name                      varchar(255),
  description               varchar(255),
  start_date                timestamp,
  end_date                  timestamp,
  active                    boolean,
  limit_categories          varchar(255),
  limit_skus                varchar(255),
  min_order                 double,
  discount                  double,
  discount_type             varchar(255),
  constraint pk_shoppingcoupon primary key (coupon_id))
;

create table shoppingitem (
  item_id                   bigint not null,
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  category_id               bigint,
  sku                       varchar(255),
  name                      varchar(255),
  description               varchar(255),
  properties                varchar(255),
  fields                    boolean,
  fields_quantities         varchar(255),
  min_quantity              integer,
  max_quantity              integer,
  price                     double,
  discount                  double,
  taxable                   boolean,
  shipping                  double,
  use_shipping_formula      boolean,
  requires_shipping         boolean,
  stock_quantity            integer,
  featured                  boolean,
  sale                      boolean,
  small_image               boolean,
  small_image_id            bigint,
  small_image_url           varchar(255),
  medium_image              boolean,
  medium_image_id           bigint,
  medium_image_url          varchar(255),
  large_image               boolean,
  large_image_id            bigint,
  large_image_url           varchar(255),
  constraint pk_shoppingitem primary key (item_id))
;

create table shoppingitemfield (
  item_field_id             bigint not null,
  item_id                   bigint,
  name                      varchar(255),
  values                    varchar(255),
  description               varchar(255),
  constraint pk_shoppingitemfield primary key (item_field_id))
;

create table shoppingitemprice (
  item_price_id             bigint not null,
  item_id                   bigint,
  min_quantity              integer,
  max_quantity              integer,
  price                     double,
  discount                  double,
  taxable                   boolean,
  shipping                  double,
  use_shipping_formula      boolean,
  status                    integer,
  constraint pk_shoppingitemprice primary key (item_price_id))
;

create table shoppingorder (
  order_id                  bigint not null,
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  number                    varchar(255),
  tax                       double,
  shipping                  double,
  alt_shipping              varchar(255),
  requires_shipping         boolean,
  insure                    boolean,
  insurance                 double,
  coupon_codes              varchar(255),
  coupon_discount           double,
  billing_first_name        varchar(255),
  billing_last_name         varchar(255),
  billing_email_address     varchar(255),
  billing_company           varchar(255),
  billing_street            varchar(255),
  billing_city              varchar(255),
  billing_state             varchar(255),
  billing_zip               varchar(255),
  billing_country           varchar(255),
  billing_phone             varchar(255),
  ship_to_billing           boolean,
  shipping_first_name       varchar(255),
  shipping_last_name        varchar(255),
  shipping_email_address    varchar(255),
  shipping_company          varchar(255),
  shipping_street           varchar(255),
  shipping_city             varchar(255),
  shipping_state            varchar(255),
  shipping_zip              varchar(255),
  shipping_country          varchar(255),
  shipping_phone            varchar(255),
  cc_name                   varchar(255),
  cc_type                   varchar(255),
  cc_number                 varchar(255),
  cc_exp_month              integer,
  cc_exp_year               integer,
  cc_ver_number             varchar(255),
  comments                  varchar(255),
  pp_txn_id                 varchar(255),
  pp_payment_status         varchar(255),
  pp_payment_gross          double,
  pp_receiver_email         varchar(255),
  pp_payer_email            varchar(255),
  send_order_email          boolean,
  send_shipping_email       boolean,
  constraint pk_shoppingorder primary key (order_id))
;

create table shoppingorderitem (
  order_item_id             bigint not null,
  order_id                  bigint,
  item_id                   varchar(255),
  sku                       varchar(255),
  name                      varchar(255),
  description               varchar(255),
  properties                varchar(255),
  price                     double,
  quantity                  integer,
  shipped_date              timestamp,
  constraint pk_shoppingorderitem primary key (order_item_id))
;

create table socialactivity (
  activity_id               bigint not null,
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  create_date               bigint,
  activity_set_id           bigint,
  mirror_activity_id        bigint,
  class_name_id             bigint,
  class_pk                  bigint,
  parent_class_name_id      bigint,
  parent_class_pk           bigint,
  customtype                integer,
  extra_data                varchar(255),
  receiver_user_id          bigint,
  constraint pk_socialactivity primary key (activity_id))
;

create table socialactivityachievement (
  activity_achievement_id   bigint not null,
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  create_date               bigint,
  name                      varchar(255),
  first_in_group            boolean,
  constraint pk_socialactivityachievement primary key (activity_achievement_id))
;

create table socialactivitycounter (
  activity_counter_id       bigint not null,
  group_id                  bigint,
  company_id                bigint,
  class_name_id             bigint,
  class_pk                  bigint,
  name                      varchar(255),
  owner_type                integer,
  current_value             integer,
  total_value               integer,
  grace_value               integer,
  start_period              integer,
  end_period                integer,
  active                    boolean,
  constraint pk_socialactivitycounter primary key (activity_counter_id))
;

create table socialactivitylimit (
  activity_limit_id         bigint not null,
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  class_name_id             bigint,
  class_pk                  bigint,
  activity_type             integer,
  activity_counter_name     varchar(255),
  value                     varchar(255),
  constraint pk_socialactivitylimit primary key (activity_limit_id))
;

create table socialactivityset (
  activity_set_id           bigint not null,
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  create_date               bigint,
  modified_date             bigint,
  class_name_id             bigint,
  class_pk                  bigint,
  customtype                integer,
  extra_data                varchar(255),
  activity_count            integer,
  constraint pk_socialactivityset primary key (activity_set_id))
;

create table socialactivitysetting (
  activity_setting_id       bigint not null,
  group_id                  bigint,
  company_id                bigint,
  class_name_id             bigint,
  activity_type             integer,
  name                      varchar(255),
  value                     varchar(255),
  constraint pk_socialactivitysetting primary key (activity_setting_id))
;

create table socialrelation (
  relation_id               bigint not null,
  uuid                      varchar(255),
  company_id                bigint,
  create_date               bigint,
  user_id1                  bigint,
  user_id2                  bigint,
  customtype                integer,
  constraint pk_socialrelation primary key (relation_id))
;

create table socialrequest (
  request_id                bigint not null,
  uuid                      varchar(255),
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  create_date               bigint,
  modified_date             bigint,
  class_name_id             bigint,
  class_pk                  bigint,
  customtype                integer,
  extra_data                varchar(255),
  receiver_user_id          bigint,
  status                    integer,
  constraint pk_socialrequest primary key (request_id))
;

create table subscription (
  subscription_id           bigint not null,
  mvcc_version              bigint,
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  class_name_id             bigint,
  class_pk                  bigint,
  frequency                 varchar(255),
  constraint pk_subscription primary key (subscription_id))
;

create table systemevent (
  system_event_id           bigint not null,
  mvcc_version              bigint,
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  class_name_id             bigint,
  class_pk                  bigint,
  class_uuid                varchar(255),
  referrer_class_name_id    bigint,
  parent_system_event_id    bigint,
  system_event_set_key      bigint,
  customtype                integer,
  extra_data                varchar(255),
  constraint pk_systemevent primary key (system_event_id))
;

create table team (
  team_id                   bigint not null,
  mvcc_version              bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  group_id                  bigint,
  name                      varchar(255),
  description               varchar(255),
  constraint pk_team primary key (team_id))
;

create table ticket (
  ticket_id                 bigint not null,
  mvcc_version              bigint,
  company_id                bigint,
  create_date               timestamp,
  class_name_id             bigint,
  class_pk                  bigint,
  key                       varchar(255),
  customtype                integer,
  extra_info                varchar(255),
  expiration_date           timestamp,
  constraint pk_ticket primary key (ticket_id))
;

create table trashentry (
  entry_id                  bigint not null,
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  class_name_id             bigint,
  class_pk                  bigint,
  system_event_set_key      bigint,
  type_settings             varchar(255),
  status                    integer,
  constraint pk_trashentry primary key (entry_id))
;

create table trashversion (
  version_id                bigint not null,
  entry_id                  bigint,
  class_name_id             bigint,
  class_pk                  bigint,
  type_settings             varchar(255),
  status                    integer,
  constraint pk_trashversion primary key (version_id))
;

create table user (
  user_id                   bigint not null,
  mvcc_version              bigint,
  uuid                      varchar(255),
  company_id                bigint,
  create_date               timestamp,
  modified_date             timestamp,
  default_user              boolean,
  contact_id                bigint,
  password                  varchar(255),
  password_encrypted        boolean,
  password_reset            boolean,
  password_modified_date    timestamp,
  digest                    varchar(255),
  reminder_query_question   varchar(255),
  reminder_query_answer     varchar(255),
  grace_login_count         integer,
  screen_name               varchar(255),
  email_address             varchar(255),
  facebook_id               bigint,
  ldap_server_id            bigint,
  open_id                   varchar(255),
  portrait_id               bigint,
  language_id               varchar(255),
  time_zone_id              varchar(255),
  greeting                  varchar(255),
  comments                  varchar(255),
  first_name                varchar(255),
  middle_name               varchar(255),
  last_name                 varchar(255),
  job_title                 varchar(255),
  login_date                timestamp,
  login_ip                  varchar(255),
  last_login_date           timestamp,
  last_login_ip             varchar(255),
  last_failed_login_date    timestamp,
  failed_login_attempts     integer,
  lockout                   boolean,
  lockout_date              timestamp,
  agreed_to_terms_of_use    boolean,
  email_address_verified    boolean,
  status                    integer,
  constraint pk_user primary key (user_id))
;

create table usergroup (
  user_group_id             bigint not null,
  mvcc_version              bigint,
  uuid                      varchar(255),
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  parent_user_group_id      bigint,
  name                      varchar(255),
  description               varchar(255),
  added_by_ldapimport       boolean,
  constraint pk_usergroup primary key (user_group_id))
;

create table useridmapper (
  user_id_mapper_id         bigint not null,
  mvcc_version              bigint,
  user_id                   bigint,
  customtype                varchar(255),
  description               varchar(255),
  external_user_id          varchar(255),
  constraint pk_useridmapper primary key (user_id_mapper_id))
;

create table usernotificationdelivery (
  user_notification_delivery_id bigint not null,
  mvcc_version              bigint,
  company_id                bigint,
  user_id                   bigint,
  portlet_id                varchar(255),
  class_name_id             bigint,
  notification_type         integer,
  delivery_type             integer,
  deliver                   boolean,
  constraint pk_usernotificationdelivery primary key (user_notification_delivery_id))
;

create table usernotificationevent (
  user_notification_event_id bigint not null,
  mvcc_version              bigint,
  uuid                      varchar(255),
  company_id                bigint,
  user_id                   bigint,
  customtype                varchar(255),
  timestamp                 bigint,
  delivery_type             integer,
  deliver_by                bigint,
  delivered                 boolean,
  payload                   varchar(255),
  action_required           boolean,
  archived                  boolean,
  constraint pk_usernotificationevent primary key (user_notification_event_id))
;

create table usertracker (
  user_tracker_id           bigint not null,
  mvcc_version              bigint,
  company_id                bigint,
  user_id                   bigint,
  modified_date             timestamp,
  session_id                varchar(255),
  remote_addr               varchar(255),
  remote_host               varchar(255),
  user_agent                varchar(255),
  constraint pk_usertracker primary key (user_tracker_id))
;

create table usertrackerpath (
  user_tracker_path_id      bigint not null,
  mvcc_version              bigint,
  user_tracker_id           bigint,
  path                      varchar(255),
  path_date                 timestamp,
  constraint pk_usertrackerpath primary key (user_tracker_path_id))
;

create table virtualhost (
  virtual_host_id           bigint not null,
  mvcc_version              bigint,
  company_id                bigint,
  layout_set_id             bigint,
  hostname                  varchar(255),
  constraint pk_virtualhost primary key (virtual_host_id))
;

create table webdavprops (
  web_dav_props_id          bigint not null,
  mvcc_version              bigint,
  company_id                bigint,
  create_date               timestamp,
  modified_date             timestamp,
  class_name_id             bigint,
  class_pk                  bigint,
  props                     varchar(255),
  constraint pk_webdavprops primary key (web_dav_props_id))
;

create table website (
  website_id                bigint not null,
  mvcc_version              bigint,
  uuid                      varchar(255),
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  class_name_id             bigint,
  class_pk                  bigint,
  url                       varchar(255),
  type_id                   bigint,
  customprimary             boolean,
  constraint pk_website primary key (website_id))
;

create table workflowdefinitionlink (
  workflow_definition_link_id bigint not null,
  mvcc_version              bigint,
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  class_name_id             bigint,
  class_pk                  bigint,
  type_pk                   bigint,
  workflow_definition_name  varchar(255),
  workflow_definition_version integer,
  constraint pk_workflowdefinitionlink primary key (workflow_definition_link_id))
;

create table workflowinstancelink (
  workflow_instance_link_id bigint not null,
  mvcc_version              bigint,
  group_id                  bigint,
  company_id                bigint,
  user_id                   bigint,
  user_name                 varchar(255),
  create_date               timestamp,
  modified_date             timestamp,
  class_name_id             bigint,
  class_pk                  bigint,
  workflow_instance_id      bigint,
  constraint pk_workflowinstancelink primary key (workflow_instance_link_id))
;

create sequence account_seq;

create sequence address_seq;

create sequence announcementsdelivery_seq;

create sequence announcementsentry_seq;

create sequence announcementsflag_seq;

create sequence assetcategory_seq;

create sequence assetcategoryproperty_seq;

create sequence assetentry_seq;

create sequence assetlink_seq;

create sequence assettag_seq;

create sequence assettagstats_seq;

create sequence assetvocabulary_seq;

create sequence backgroundtask_seq;

create sequence blogsentry_seq;

create sequence blogsstatsuser_seq;

create sequence browsertracker_seq;

create sequence calevent_seq;

create sequence classname_seq;

create sequence clustergroup_seq;

create sequence company_seq;

create sequence contact_seq;

create sequence country_seq;

create sequence customgroup_seq;

create sequence ddlrecord_seq;

create sequence ddlrecordset_seq;

create sequence ddlrecordversion_seq;

create sequence ddmcontent_seq;

create sequence ddmstoragelink_seq;

create sequence ddmstructure_seq;

create sequence ddmstructurelayout_seq;

create sequence ddmstructurelink_seq;

create sequence ddmstructureversion_seq;

create sequence ddmtemplate_seq;

create sequence ddmtemplateversion_seq;

create sequence dlcontent_seq;

create sequence dlfileentry_seq;

create sequence dlfileentrymetadata_seq;

create sequence dlfileentrytype_seq;

create sequence dlfilerank_seq;

create sequence dlfileshortcut_seq;

create sequence dlfileversion_seq;

create sequence dlfolder_seq;

create sequence dlsyncevent_seq;

create sequence emailaddress_seq;

create sequence expandocolumn_seq;

create sequence expandorow_seq;

create sequence expandotable_seq;

create sequence expandovalue_seq;

create sequence exportimportconfiguration_seq;

create sequence image_seq;

create sequence journalarticle_seq;

create sequence journalarticleimage_seq;

create sequence journalarticleresource_seq;

create sequence journalcontentsearch_seq;

create sequence journalfeed_seq;

create sequence journalfolder_seq;

create sequence layout_seq;

create sequence layoutbranch_seq;

create sequence layoutfriendlyurl_seq;

create sequence layoutprototype_seq;

create sequence layoutrevision_seq;

create sequence layoutset_seq;

create sequence layoutsetbranch_seq;

create sequence layoutsetprototype_seq;

create sequence listtype_seq;

create sequence lock_seq;

create sequence mbban_seq;

create sequence mbcategory_seq;

create sequence mbdiscussion_seq;

create sequence mbmailinglist_seq;

create sequence mbmessage_seq;

create sequence mbstatsuser_seq;

create sequence mbthread_seq;

create sequence mbthreadflag_seq;

create sequence mdraction_seq;

create sequence mdrrule_seq;

create sequence mdrrulegroup_seq;

create sequence mdrrulegroupinstance_seq;

create sequence membershiprequest_seq;

create sequence organization_seq;

create sequence orglabor_seq;

create sequence passwordpolicy_seq;

create sequence passwordpolicyrel_seq;

create sequence passwordtracker_seq;

create sequence phone_seq;

create sequence pluginsetting_seq;

create sequence portalpreferences_seq;

create sequence portlet_seq;

create sequence portletitem_seq;

create sequence portletpreferences_seq;

create sequence ratingsentry_seq;

create sequence ratingsstats_seq;

create sequence region_seq;

create sequence release_seq;

create sequence repository_seq;

create sequence repositoryentry_seq;

create sequence resourceaction_seq;

create sequence resourceblock_seq;

create sequence resourceblockpermission_seq;

create sequence resourcepermission_seq;

create sequence resourcetypepermission_seq;

create sequence role_seq;

create sequence scframeworkversion_seq;

create sequence sclicense_seq;

create sequence scproductentry_seq;

create sequence scproductscreenshot_seq;

create sequence scproductversion_seq;

create sequence servicecomponent_seq;

create sequence shard_seq;

create sequence shoppingcart_seq;

create sequence shoppingcategory_seq;

create sequence shoppingcoupon_seq;

create sequence shoppingitem_seq;

create sequence shoppingitemfield_seq;

create sequence shoppingitemprice_seq;

create sequence shoppingorder_seq;

create sequence shoppingorderitem_seq;

create sequence socialactivity_seq;

create sequence socialactivityachievement_seq;

create sequence socialactivitycounter_seq;

create sequence socialactivitylimit_seq;

create sequence socialactivityset_seq;

create sequence socialactivitysetting_seq;

create sequence socialrelation_seq;

create sequence socialrequest_seq;

create sequence subscription_seq;

create sequence systemevent_seq;

create sequence team_seq;

create sequence ticket_seq;

create sequence trashentry_seq;

create sequence trashversion_seq;

create sequence user_seq;

create sequence usergroup_seq;

create sequence useridmapper_seq;

create sequence usernotificationdelivery_seq;

create sequence usernotificationevent_seq;

create sequence usertracker_seq;

create sequence usertrackerpath_seq;

create sequence virtualhost_seq;

create sequence webdavprops_seq;

create sequence website_seq;

create sequence workflowdefinitionlink_seq;

create sequence workflowinstancelink_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists account;

drop table if exists address;

drop table if exists announcementsdelivery;

drop table if exists announcementsentry;

drop table if exists announcementsflag;

drop table if exists assetcategory;

drop table if exists assetcategoryproperty;

drop table if exists assetentry;

drop table if exists assetlink;

drop table if exists assettag;

drop table if exists assettagstats;

drop table if exists assetvocabulary;

drop table if exists backgroundtask;

drop table if exists blogsentry;

drop table if exists blogsstatsuser;

drop table if exists browsertracker;

drop table if exists calevent;

drop table if exists classname;

drop table if exists clustergroup;

drop table if exists company;

drop table if exists contact;

drop table if exists country;

drop table if exists customgroup;

drop table if exists ddlrecord;

drop table if exists ddlrecordset;

drop table if exists ddlrecordversion;

drop table if exists ddmcontent;

drop table if exists ddmstoragelink;

drop table if exists ddmstructure;

drop table if exists ddmstructurelayout;

drop table if exists ddmstructurelink;

drop table if exists ddmstructureversion;

drop table if exists ddmtemplate;

drop table if exists ddmtemplateversion;

drop table if exists dlcontent;

drop table if exists dlfileentry;

drop table if exists dlfileentrymetadata;

drop table if exists dlfileentrytype;

drop table if exists dlfilerank;

drop table if exists dlfileshortcut;

drop table if exists dlfileversion;

drop table if exists dlfolder;

drop table if exists dlsyncevent;

drop table if exists emailaddress;

drop table if exists expandocolumn;

drop table if exists expandorow;

drop table if exists expandotable;

drop table if exists expandovalue;

drop table if exists exportimportconfiguration;

drop table if exists image;

drop table if exists journalarticle;

drop table if exists journalarticleimage;

drop table if exists journalarticleresource;

drop table if exists journalcontentsearch;

drop table if exists journalfeed;

drop table if exists journalfolder;

drop table if exists layout;

drop table if exists layoutbranch;

drop table if exists layoutfriendlyurl;

drop table if exists layoutprototype;

drop table if exists layoutrevision;

drop table if exists layoutset;

drop table if exists layoutsetbranch;

drop table if exists layoutsetprototype;

drop table if exists listtype;

drop table if exists lock;

drop table if exists mbban;

drop table if exists mbcategory;

drop table if exists mbdiscussion;

drop table if exists mbmailinglist;

drop table if exists mbmessage;

drop table if exists mbstatsuser;

drop table if exists mbthread;

drop table if exists mbthreadflag;

drop table if exists mdraction;

drop table if exists mdrrule;

drop table if exists mdrrulegroup;

drop table if exists mdrrulegroupinstance;

drop table if exists membershiprequest;

drop table if exists organization;

drop table if exists orglabor;

drop table if exists passwordpolicy;

drop table if exists passwordpolicyrel;

drop table if exists passwordtracker;

drop table if exists phone;

drop table if exists pluginsetting;

drop table if exists portalpreferences;

drop table if exists portlet;

drop table if exists portletitem;

drop table if exists portletpreferences;

drop table if exists ratingsentry;

drop table if exists ratingsstats;

drop table if exists region;

drop table if exists release;

drop table if exists repository;

drop table if exists repositoryentry;

drop table if exists resourceaction;

drop table if exists resourceblock;

drop table if exists resourceblockpermission;

drop table if exists resourcepermission;

drop table if exists resourcetypepermission;

drop table if exists role;

drop table if exists scframeworkversion;

drop table if exists sclicense;

drop table if exists scproductentry;

drop table if exists scproductscreenshot;

drop table if exists scproductversion;

drop table if exists servicecomponent;

drop table if exists shard;

drop table if exists shoppingcart;

drop table if exists shoppingcategory;

drop table if exists shoppingcoupon;

drop table if exists shoppingitem;

drop table if exists shoppingitemfield;

drop table if exists shoppingitemprice;

drop table if exists shoppingorder;

drop table if exists shoppingorderitem;

drop table if exists socialactivity;

drop table if exists socialactivityachievement;

drop table if exists socialactivitycounter;

drop table if exists socialactivitylimit;

drop table if exists socialactivityset;

drop table if exists socialactivitysetting;

drop table if exists socialrelation;

drop table if exists socialrequest;

drop table if exists subscription;

drop table if exists systemevent;

drop table if exists team;

drop table if exists ticket;

drop table if exists trashentry;

drop table if exists trashversion;

drop table if exists user;

drop table if exists usergroup;

drop table if exists useridmapper;

drop table if exists usernotificationdelivery;

drop table if exists usernotificationevent;

drop table if exists usertracker;

drop table if exists usertrackerpath;

drop table if exists virtualhost;

drop table if exists webdavprops;

drop table if exists website;

drop table if exists workflowdefinitionlink;

drop table if exists workflowinstancelink;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists account_seq;

drop sequence if exists address_seq;

drop sequence if exists announcementsdelivery_seq;

drop sequence if exists announcementsentry_seq;

drop sequence if exists announcementsflag_seq;

drop sequence if exists assetcategory_seq;

drop sequence if exists assetcategoryproperty_seq;

drop sequence if exists assetentry_seq;

drop sequence if exists assetlink_seq;

drop sequence if exists assettag_seq;

drop sequence if exists assettagstats_seq;

drop sequence if exists assetvocabulary_seq;

drop sequence if exists backgroundtask_seq;

drop sequence if exists blogsentry_seq;

drop sequence if exists blogsstatsuser_seq;

drop sequence if exists browsertracker_seq;

drop sequence if exists calevent_seq;

drop sequence if exists classname_seq;

drop sequence if exists clustergroup_seq;

drop sequence if exists company_seq;

drop sequence if exists contact_seq;

drop sequence if exists country_seq;

drop sequence if exists customgroup_seq;

drop sequence if exists ddlrecord_seq;

drop sequence if exists ddlrecordset_seq;

drop sequence if exists ddlrecordversion_seq;

drop sequence if exists ddmcontent_seq;

drop sequence if exists ddmstoragelink_seq;

drop sequence if exists ddmstructure_seq;

drop sequence if exists ddmstructurelayout_seq;

drop sequence if exists ddmstructurelink_seq;

drop sequence if exists ddmstructureversion_seq;

drop sequence if exists ddmtemplate_seq;

drop sequence if exists ddmtemplateversion_seq;

drop sequence if exists dlcontent_seq;

drop sequence if exists dlfileentry_seq;

drop sequence if exists dlfileentrymetadata_seq;

drop sequence if exists dlfileentrytype_seq;

drop sequence if exists dlfilerank_seq;

drop sequence if exists dlfileshortcut_seq;

drop sequence if exists dlfileversion_seq;

drop sequence if exists dlfolder_seq;

drop sequence if exists dlsyncevent_seq;

drop sequence if exists emailaddress_seq;

drop sequence if exists expandocolumn_seq;

drop sequence if exists expandorow_seq;

drop sequence if exists expandotable_seq;

drop sequence if exists expandovalue_seq;

drop sequence if exists exportimportconfiguration_seq;

drop sequence if exists image_seq;

drop sequence if exists journalarticle_seq;

drop sequence if exists journalarticleimage_seq;

drop sequence if exists journalarticleresource_seq;

drop sequence if exists journalcontentsearch_seq;

drop sequence if exists journalfeed_seq;

drop sequence if exists journalfolder_seq;

drop sequence if exists layout_seq;

drop sequence if exists layoutbranch_seq;

drop sequence if exists layoutfriendlyurl_seq;

drop sequence if exists layoutprototype_seq;

drop sequence if exists layoutrevision_seq;

drop sequence if exists layoutset_seq;

drop sequence if exists layoutsetbranch_seq;

drop sequence if exists layoutsetprototype_seq;

drop sequence if exists listtype_seq;

drop sequence if exists lock_seq;

drop sequence if exists mbban_seq;

drop sequence if exists mbcategory_seq;

drop sequence if exists mbdiscussion_seq;

drop sequence if exists mbmailinglist_seq;

drop sequence if exists mbmessage_seq;

drop sequence if exists mbstatsuser_seq;

drop sequence if exists mbthread_seq;

drop sequence if exists mbthreadflag_seq;

drop sequence if exists mdraction_seq;

drop sequence if exists mdrrule_seq;

drop sequence if exists mdrrulegroup_seq;

drop sequence if exists mdrrulegroupinstance_seq;

drop sequence if exists membershiprequest_seq;

drop sequence if exists organization_seq;

drop sequence if exists orglabor_seq;

drop sequence if exists passwordpolicy_seq;

drop sequence if exists passwordpolicyrel_seq;

drop sequence if exists passwordtracker_seq;

drop sequence if exists phone_seq;

drop sequence if exists pluginsetting_seq;

drop sequence if exists portalpreferences_seq;

drop sequence if exists portlet_seq;

drop sequence if exists portletitem_seq;

drop sequence if exists portletpreferences_seq;

drop sequence if exists ratingsentry_seq;

drop sequence if exists ratingsstats_seq;

drop sequence if exists region_seq;

drop sequence if exists release_seq;

drop sequence if exists repository_seq;

drop sequence if exists repositoryentry_seq;

drop sequence if exists resourceaction_seq;

drop sequence if exists resourceblock_seq;

drop sequence if exists resourceblockpermission_seq;

drop sequence if exists resourcepermission_seq;

drop sequence if exists resourcetypepermission_seq;

drop sequence if exists role_seq;

drop sequence if exists scframeworkversion_seq;

drop sequence if exists sclicense_seq;

drop sequence if exists scproductentry_seq;

drop sequence if exists scproductscreenshot_seq;

drop sequence if exists scproductversion_seq;

drop sequence if exists servicecomponent_seq;

drop sequence if exists shard_seq;

drop sequence if exists shoppingcart_seq;

drop sequence if exists shoppingcategory_seq;

drop sequence if exists shoppingcoupon_seq;

drop sequence if exists shoppingitem_seq;

drop sequence if exists shoppingitemfield_seq;

drop sequence if exists shoppingitemprice_seq;

drop sequence if exists shoppingorder_seq;

drop sequence if exists shoppingorderitem_seq;

drop sequence if exists socialactivity_seq;

drop sequence if exists socialactivityachievement_seq;

drop sequence if exists socialactivitycounter_seq;

drop sequence if exists socialactivitylimit_seq;

drop sequence if exists socialactivityset_seq;

drop sequence if exists socialactivitysetting_seq;

drop sequence if exists socialrelation_seq;

drop sequence if exists socialrequest_seq;

drop sequence if exists subscription_seq;

drop sequence if exists systemevent_seq;

drop sequence if exists team_seq;

drop sequence if exists ticket_seq;

drop sequence if exists trashentry_seq;

drop sequence if exists trashversion_seq;

drop sequence if exists user_seq;

drop sequence if exists usergroup_seq;

drop sequence if exists useridmapper_seq;

drop sequence if exists usernotificationdelivery_seq;

drop sequence if exists usernotificationevent_seq;

drop sequence if exists usertracker_seq;

drop sequence if exists usertrackerpath_seq;

drop sequence if exists virtualhost_seq;

drop sequence if exists webdavprops_seq;

drop sequence if exists website_seq;

drop sequence if exists workflowdefinitionlink_seq;

drop sequence if exists workflowinstancelink_seq;

