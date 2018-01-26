/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rivetlogic.ecommerce.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.rivetlogic.ecommerce.model.ShoppingOrder;
import com.rivetlogic.ecommerce.model.ShoppingOrderModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ShoppingOrder service. Represents a row in the &quot;rivetlogic_ecommerce_ShoppingOrder&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link ShoppingOrderModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ShoppingOrderImpl}.
 * </p>
 *
 * @author rivetlogic
 * @see ShoppingOrderImpl
 * @see ShoppingOrder
 * @see ShoppingOrderModel
 * @generated
 */
@ProviderType
public class ShoppingOrderModelImpl extends BaseModelImpl<ShoppingOrder>
	implements ShoppingOrderModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a Shopping Order model instance should use the {@link ShoppingOrder} interface instead.
	 */
	public static final String TABLE_NAME = "rivetlogic_ecommerce_ShoppingOrder";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "orderId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "orderStatus", Types.VARCHAR },
			{ "customerEmail", Types.VARCHAR },
			{ "customerName", Types.VARCHAR },
			{ "customerPhone", Types.VARCHAR },
			{ "shippingAddress1", Types.VARCHAR },
			{ "shippingAddress2", Types.VARCHAR },
			{ "shippingCity", Types.VARCHAR },
			{ "shippingPostalCode", Types.VARCHAR },
			{ "shippingStateProvince", Types.VARCHAR },
			{ "shippingCountry", Types.VARCHAR },
			{ "total", Types.DOUBLE },
			{ "notes", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("orderId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("orderStatus", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("customerEmail", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("customerName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("customerPhone", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("shippingAddress1", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("shippingAddress2", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("shippingCity", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("shippingPostalCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("shippingStateProvince", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("shippingCountry", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("total", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("notes", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table rivetlogic_ecommerce_ShoppingOrder (uuid_ VARCHAR(75) null,orderId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,orderStatus VARCHAR(75) null,customerEmail VARCHAR(75) null,customerName VARCHAR(75) null,customerPhone VARCHAR(75) null,shippingAddress1 VARCHAR(75) null,shippingAddress2 VARCHAR(75) null,shippingCity VARCHAR(75) null,shippingPostalCode VARCHAR(75) null,shippingStateProvince VARCHAR(75) null,shippingCountry VARCHAR(75) null,total DOUBLE,notes VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table rivetlogic_ecommerce_ShoppingOrder";
	public static final String ORDER_BY_JPQL = " ORDER BY shoppingOrder.orderId DESC";
	public static final String ORDER_BY_SQL = " ORDER BY rivetlogic_ecommerce_ShoppingOrder.orderId DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.rivetlogic.ecommerce.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rivetlogic.ecommerce.model.ShoppingOrder"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.rivetlogic.ecommerce.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rivetlogic.ecommerce.model.ShoppingOrder"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.rivetlogic.ecommerce.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.rivetlogic.ecommerce.model.ShoppingOrder"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long ORDERSTATUS_COLUMN_BITMASK = 4L;
	public static final long USERID_COLUMN_BITMASK = 8L;
	public static final long UUID_COLUMN_BITMASK = 16L;
	public static final long ORDERID_COLUMN_BITMASK = 32L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.rivetlogic.ecommerce.service.util.ServiceProps.get(
				"lock.expiration.time.com.rivetlogic.ecommerce.model.ShoppingOrder"));

	public ShoppingOrderModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _orderId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setOrderId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _orderId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ShoppingOrder.class;
	}

	@Override
	public String getModelClassName() {
		return ShoppingOrder.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("orderId", getOrderId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("orderStatus", getOrderStatus());
		attributes.put("customerEmail", getCustomerEmail());
		attributes.put("customerName", getCustomerName());
		attributes.put("customerPhone", getCustomerPhone());
		attributes.put("shippingAddress1", getShippingAddress1());
		attributes.put("shippingAddress2", getShippingAddress2());
		attributes.put("shippingCity", getShippingCity());
		attributes.put("shippingPostalCode", getShippingPostalCode());
		attributes.put("shippingStateProvince", getShippingStateProvince());
		attributes.put("shippingCountry", getShippingCountry());
		attributes.put("total", getTotal());
		attributes.put("notes", getNotes());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long orderId = (Long)attributes.get("orderId");

		if (orderId != null) {
			setOrderId(orderId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String orderStatus = (String)attributes.get("orderStatus");

		if (orderStatus != null) {
			setOrderStatus(orderStatus);
		}

		String customerEmail = (String)attributes.get("customerEmail");

		if (customerEmail != null) {
			setCustomerEmail(customerEmail);
		}

		String customerName = (String)attributes.get("customerName");

		if (customerName != null) {
			setCustomerName(customerName);
		}

		String customerPhone = (String)attributes.get("customerPhone");

		if (customerPhone != null) {
			setCustomerPhone(customerPhone);
		}

		String shippingAddress1 = (String)attributes.get("shippingAddress1");

		if (shippingAddress1 != null) {
			setShippingAddress1(shippingAddress1);
		}

		String shippingAddress2 = (String)attributes.get("shippingAddress2");

		if (shippingAddress2 != null) {
			setShippingAddress2(shippingAddress2);
		}

		String shippingCity = (String)attributes.get("shippingCity");

		if (shippingCity != null) {
			setShippingCity(shippingCity);
		}

		String shippingPostalCode = (String)attributes.get("shippingPostalCode");

		if (shippingPostalCode != null) {
			setShippingPostalCode(shippingPostalCode);
		}

		String shippingStateProvince = (String)attributes.get(
				"shippingStateProvince");

		if (shippingStateProvince != null) {
			setShippingStateProvince(shippingStateProvince);
		}

		String shippingCountry = (String)attributes.get("shippingCountry");

		if (shippingCountry != null) {
			setShippingCountry(shippingCountry);
		}

		Double total = (Double)attributes.get("total");

		if (total != null) {
			setTotal(total);
		}

		String notes = (String)attributes.get("notes");

		if (notes != null) {
			setNotes(notes);
		}
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getOrderId() {
		return _orderId;
	}

	@Override
	public void setOrderId(long orderId) {
		_columnBitmask = -1L;

		_orderId = orderId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public String getOrderStatus() {
		if (_orderStatus == null) {
			return StringPool.BLANK;
		}
		else {
			return _orderStatus;
		}
	}

	@Override
	public void setOrderStatus(String orderStatus) {
		_columnBitmask |= ORDERSTATUS_COLUMN_BITMASK;

		if (_originalOrderStatus == null) {
			_originalOrderStatus = _orderStatus;
		}

		_orderStatus = orderStatus;
	}

	public String getOriginalOrderStatus() {
		return GetterUtil.getString(_originalOrderStatus);
	}

	@Override
	public String getCustomerEmail() {
		if (_customerEmail == null) {
			return StringPool.BLANK;
		}
		else {
			return _customerEmail;
		}
	}

	@Override
	public void setCustomerEmail(String customerEmail) {
		_customerEmail = customerEmail;
	}

	@Override
	public String getCustomerName() {
		if (_customerName == null) {
			return StringPool.BLANK;
		}
		else {
			return _customerName;
		}
	}

	@Override
	public void setCustomerName(String customerName) {
		_customerName = customerName;
	}

	@Override
	public String getCustomerPhone() {
		if (_customerPhone == null) {
			return StringPool.BLANK;
		}
		else {
			return _customerPhone;
		}
	}

	@Override
	public void setCustomerPhone(String customerPhone) {
		_customerPhone = customerPhone;
	}

	@Override
	public String getShippingAddress1() {
		if (_shippingAddress1 == null) {
			return StringPool.BLANK;
		}
		else {
			return _shippingAddress1;
		}
	}

	@Override
	public void setShippingAddress1(String shippingAddress1) {
		_shippingAddress1 = shippingAddress1;
	}

	@Override
	public String getShippingAddress2() {
		if (_shippingAddress2 == null) {
			return StringPool.BLANK;
		}
		else {
			return _shippingAddress2;
		}
	}

	@Override
	public void setShippingAddress2(String shippingAddress2) {
		_shippingAddress2 = shippingAddress2;
	}

	@Override
	public String getShippingCity() {
		if (_shippingCity == null) {
			return StringPool.BLANK;
		}
		else {
			return _shippingCity;
		}
	}

	@Override
	public void setShippingCity(String shippingCity) {
		_shippingCity = shippingCity;
	}

	@Override
	public String getShippingPostalCode() {
		if (_shippingPostalCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _shippingPostalCode;
		}
	}

	@Override
	public void setShippingPostalCode(String shippingPostalCode) {
		_shippingPostalCode = shippingPostalCode;
	}

	@Override
	public String getShippingStateProvince() {
		if (_shippingStateProvince == null) {
			return StringPool.BLANK;
		}
		else {
			return _shippingStateProvince;
		}
	}

	@Override
	public void setShippingStateProvince(String shippingStateProvince) {
		_shippingStateProvince = shippingStateProvince;
	}

	@Override
	public String getShippingCountry() {
		if (_shippingCountry == null) {
			return StringPool.BLANK;
		}
		else {
			return _shippingCountry;
		}
	}

	@Override
	public void setShippingCountry(String shippingCountry) {
		_shippingCountry = shippingCountry;
	}

	@Override
	public double getTotal() {
		return _total;
	}

	@Override
	public void setTotal(double total) {
		_total = total;
	}

	@Override
	public String getNotes() {
		if (_notes == null) {
			return StringPool.BLANK;
		}
		else {
			return _notes;
		}
	}

	@Override
	public void setNotes(String notes) {
		_notes = notes;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ShoppingOrder.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ShoppingOrder.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ShoppingOrder toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ShoppingOrder)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ShoppingOrderImpl shoppingOrderImpl = new ShoppingOrderImpl();

		shoppingOrderImpl.setUuid(getUuid());
		shoppingOrderImpl.setOrderId(getOrderId());
		shoppingOrderImpl.setGroupId(getGroupId());
		shoppingOrderImpl.setCompanyId(getCompanyId());
		shoppingOrderImpl.setUserId(getUserId());
		shoppingOrderImpl.setCreateDate(getCreateDate());
		shoppingOrderImpl.setModifiedDate(getModifiedDate());
		shoppingOrderImpl.setOrderStatus(getOrderStatus());
		shoppingOrderImpl.setCustomerEmail(getCustomerEmail());
		shoppingOrderImpl.setCustomerName(getCustomerName());
		shoppingOrderImpl.setCustomerPhone(getCustomerPhone());
		shoppingOrderImpl.setShippingAddress1(getShippingAddress1());
		shoppingOrderImpl.setShippingAddress2(getShippingAddress2());
		shoppingOrderImpl.setShippingCity(getShippingCity());
		shoppingOrderImpl.setShippingPostalCode(getShippingPostalCode());
		shoppingOrderImpl.setShippingStateProvince(getShippingStateProvince());
		shoppingOrderImpl.setShippingCountry(getShippingCountry());
		shoppingOrderImpl.setTotal(getTotal());
		shoppingOrderImpl.setNotes(getNotes());

		shoppingOrderImpl.resetOriginalValues();

		return shoppingOrderImpl;
	}

	@Override
	public int compareTo(ShoppingOrder shoppingOrder) {
		int value = 0;

		if (getOrderId() < shoppingOrder.getOrderId()) {
			value = -1;
		}
		else if (getOrderId() > shoppingOrder.getOrderId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ShoppingOrder)) {
			return false;
		}

		ShoppingOrder shoppingOrder = (ShoppingOrder)obj;

		long primaryKey = shoppingOrder.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		ShoppingOrderModelImpl shoppingOrderModelImpl = this;

		shoppingOrderModelImpl._originalUuid = shoppingOrderModelImpl._uuid;

		shoppingOrderModelImpl._originalGroupId = shoppingOrderModelImpl._groupId;

		shoppingOrderModelImpl._setOriginalGroupId = false;

		shoppingOrderModelImpl._originalCompanyId = shoppingOrderModelImpl._companyId;

		shoppingOrderModelImpl._setOriginalCompanyId = false;

		shoppingOrderModelImpl._originalUserId = shoppingOrderModelImpl._userId;

		shoppingOrderModelImpl._setOriginalUserId = false;

		shoppingOrderModelImpl._setModifiedDate = false;

		shoppingOrderModelImpl._originalOrderStatus = shoppingOrderModelImpl._orderStatus;

		shoppingOrderModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ShoppingOrder> toCacheModel() {
		ShoppingOrderCacheModel shoppingOrderCacheModel = new ShoppingOrderCacheModel();

		shoppingOrderCacheModel.uuid = getUuid();

		String uuid = shoppingOrderCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			shoppingOrderCacheModel.uuid = null;
		}

		shoppingOrderCacheModel.orderId = getOrderId();

		shoppingOrderCacheModel.groupId = getGroupId();

		shoppingOrderCacheModel.companyId = getCompanyId();

		shoppingOrderCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			shoppingOrderCacheModel.createDate = createDate.getTime();
		}
		else {
			shoppingOrderCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			shoppingOrderCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			shoppingOrderCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		shoppingOrderCacheModel.orderStatus = getOrderStatus();

		String orderStatus = shoppingOrderCacheModel.orderStatus;

		if ((orderStatus != null) && (orderStatus.length() == 0)) {
			shoppingOrderCacheModel.orderStatus = null;
		}

		shoppingOrderCacheModel.customerEmail = getCustomerEmail();

		String customerEmail = shoppingOrderCacheModel.customerEmail;

		if ((customerEmail != null) && (customerEmail.length() == 0)) {
			shoppingOrderCacheModel.customerEmail = null;
		}

		shoppingOrderCacheModel.customerName = getCustomerName();

		String customerName = shoppingOrderCacheModel.customerName;

		if ((customerName != null) && (customerName.length() == 0)) {
			shoppingOrderCacheModel.customerName = null;
		}

		shoppingOrderCacheModel.customerPhone = getCustomerPhone();

		String customerPhone = shoppingOrderCacheModel.customerPhone;

		if ((customerPhone != null) && (customerPhone.length() == 0)) {
			shoppingOrderCacheModel.customerPhone = null;
		}

		shoppingOrderCacheModel.shippingAddress1 = getShippingAddress1();

		String shippingAddress1 = shoppingOrderCacheModel.shippingAddress1;

		if ((shippingAddress1 != null) && (shippingAddress1.length() == 0)) {
			shoppingOrderCacheModel.shippingAddress1 = null;
		}

		shoppingOrderCacheModel.shippingAddress2 = getShippingAddress2();

		String shippingAddress2 = shoppingOrderCacheModel.shippingAddress2;

		if ((shippingAddress2 != null) && (shippingAddress2.length() == 0)) {
			shoppingOrderCacheModel.shippingAddress2 = null;
		}

		shoppingOrderCacheModel.shippingCity = getShippingCity();

		String shippingCity = shoppingOrderCacheModel.shippingCity;

		if ((shippingCity != null) && (shippingCity.length() == 0)) {
			shoppingOrderCacheModel.shippingCity = null;
		}

		shoppingOrderCacheModel.shippingPostalCode = getShippingPostalCode();

		String shippingPostalCode = shoppingOrderCacheModel.shippingPostalCode;

		if ((shippingPostalCode != null) && (shippingPostalCode.length() == 0)) {
			shoppingOrderCacheModel.shippingPostalCode = null;
		}

		shoppingOrderCacheModel.shippingStateProvince = getShippingStateProvince();

		String shippingStateProvince = shoppingOrderCacheModel.shippingStateProvince;

		if ((shippingStateProvince != null) &&
				(shippingStateProvince.length() == 0)) {
			shoppingOrderCacheModel.shippingStateProvince = null;
		}

		shoppingOrderCacheModel.shippingCountry = getShippingCountry();

		String shippingCountry = shoppingOrderCacheModel.shippingCountry;

		if ((shippingCountry != null) && (shippingCountry.length() == 0)) {
			shoppingOrderCacheModel.shippingCountry = null;
		}

		shoppingOrderCacheModel.total = getTotal();

		shoppingOrderCacheModel.notes = getNotes();

		String notes = shoppingOrderCacheModel.notes;

		if ((notes != null) && (notes.length() == 0)) {
			shoppingOrderCacheModel.notes = null;
		}

		return shoppingOrderCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", orderId=");
		sb.append(getOrderId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", orderStatus=");
		sb.append(getOrderStatus());
		sb.append(", customerEmail=");
		sb.append(getCustomerEmail());
		sb.append(", customerName=");
		sb.append(getCustomerName());
		sb.append(", customerPhone=");
		sb.append(getCustomerPhone());
		sb.append(", shippingAddress1=");
		sb.append(getShippingAddress1());
		sb.append(", shippingAddress2=");
		sb.append(getShippingAddress2());
		sb.append(", shippingCity=");
		sb.append(getShippingCity());
		sb.append(", shippingPostalCode=");
		sb.append(getShippingPostalCode());
		sb.append(", shippingStateProvince=");
		sb.append(getShippingStateProvince());
		sb.append(", shippingCountry=");
		sb.append(getShippingCountry());
		sb.append(", total=");
		sb.append(getTotal());
		sb.append(", notes=");
		sb.append(getNotes());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.rivetlogic.ecommerce.model.ShoppingOrder");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orderId</column-name><column-value><![CDATA[");
		sb.append(getOrderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orderStatus</column-name><column-value><![CDATA[");
		sb.append(getOrderStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customerEmail</column-name><column-value><![CDATA[");
		sb.append(getCustomerEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customerName</column-name><column-value><![CDATA[");
		sb.append(getCustomerName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customerPhone</column-name><column-value><![CDATA[");
		sb.append(getCustomerPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippingAddress1</column-name><column-value><![CDATA[");
		sb.append(getShippingAddress1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippingAddress2</column-name><column-value><![CDATA[");
		sb.append(getShippingAddress2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippingCity</column-name><column-value><![CDATA[");
		sb.append(getShippingCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippingPostalCode</column-name><column-value><![CDATA[");
		sb.append(getShippingPostalCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippingStateProvince</column-name><column-value><![CDATA[");
		sb.append(getShippingStateProvince());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippingCountry</column-name><column-value><![CDATA[");
		sb.append(getShippingCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>total</column-name><column-value><![CDATA[");
		sb.append(getTotal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notes</column-name><column-value><![CDATA[");
		sb.append(getNotes());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = ShoppingOrder.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			ShoppingOrder.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _orderId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _orderStatus;
	private String _originalOrderStatus;
	private String _customerEmail;
	private String _customerName;
	private String _customerPhone;
	private String _shippingAddress1;
	private String _shippingAddress2;
	private String _shippingCity;
	private String _shippingPostalCode;
	private String _shippingStateProvince;
	private String _shippingCountry;
	private double _total;
	private String _notes;
	private long _columnBitmask;
	private ShoppingOrder _escapedModel;
}