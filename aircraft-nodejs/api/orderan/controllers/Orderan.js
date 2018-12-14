'use strict';

/**
 * Orderan.js controller
 *
 * @description: A set of functions called "actions" for managing `Orderan`.
 */

module.exports = {

  /**
   * Retrieve orderan records.
   *
   * @return {Object|Array}
   */

  find: async (ctx) => {
    if (ctx.query._q) {
      return strapi.services.orderan.search(ctx.query);
    } else {
      return strapi.services.orderan.fetchAll(ctx.query);
    }
  },

  /**
   * Retrieve a orderan record.
   *
   * @return {Object}
   */

  findOne: async (ctx) => {
    return strapi.services.orderan.fetch(ctx.params);
  },

  /**
   * Count orderan records.
   *
   * @return {Number}
   */

  count: async (ctx) => {
    return strapi.services.orderan.count(ctx.query);
  },

  /**
   * Create a/an orderan record.
   *
   * @return {Object}
   */

  create: async (ctx) => {
    return strapi.services.orderan.add(ctx.request.body);
  },

  /**
   * Update a/an orderan record.
   *
   * @return {Object}
   */

  update: async (ctx, next) => {
    return strapi.services.orderan.edit(ctx.params, ctx.request.body) ;
  },

  /**
   * Destroy a/an orderan record.
   *
   * @return {Object}
   */

  destroy: async (ctx, next) => {
    return strapi.services.orderan.remove(ctx.params);
  },

  /**
   * Add relation to a/an orderan record.
   *
   * @return {Object}
   */

  createRelation: async (ctx, next) => {
    return strapi.services.orderan.addRelation(ctx.params, ctx.request.body);
  },

  /**
   * Update relation to a/an orderan record.
   *
   * @return {Object}
   */

  updateRelation: async (ctx, next) => {
    return strapi.services.orderan.editRelation(ctx.params, ctx.request.body);
  },

  /**
   * Destroy relation to a/an orderan record.
   *
   * @return {Object}
   */

  destroyRelation: async (ctx, next) => {
    return strapi.services.orderan.removeRelation(ctx.params, ctx.request.body);
  }
};
