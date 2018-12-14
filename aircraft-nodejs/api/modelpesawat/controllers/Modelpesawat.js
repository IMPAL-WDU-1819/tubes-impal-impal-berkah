'use strict';

/**
 * Modelpesawat.js controller
 *
 * @description: A set of functions called "actions" for managing `Modelpesawat`.
 */

module.exports = {

  /**
   * Retrieve modelpesawat records.
   *
   * @return {Object|Array}
   */

  find: async (ctx) => {
    if (ctx.query._q) {
      return strapi.services.modelpesawat.search(ctx.query);
    } else {
      return strapi.services.modelpesawat.fetchAll(ctx.query);
    }
  },

  /**
   * Retrieve a modelpesawat record.
   *
   * @return {Object}
   */

  findOne: async (ctx) => {
    return strapi.services.modelpesawat.fetch(ctx.params);
  },

  /**
   * Count modelpesawat records.
   *
   * @return {Number}
   */

  count: async (ctx) => {
    return strapi.services.modelpesawat.count(ctx.query);
  },

  /**
   * Create a/an modelpesawat record.
   *
   * @return {Object}
   */

  create: async (ctx) => {
    return strapi.services.modelpesawat.add(ctx.request.body);
  },

  /**
   * Update a/an modelpesawat record.
   *
   * @return {Object}
   */

  update: async (ctx, next) => {
    return strapi.services.modelpesawat.edit(ctx.params, ctx.request.body) ;
  },

  /**
   * Destroy a/an modelpesawat record.
   *
   * @return {Object}
   */

  destroy: async (ctx, next) => {
    return strapi.services.modelpesawat.remove(ctx.params);
  },

  /**
   * Add relation to a/an modelpesawat record.
   *
   * @return {Object}
   */

  createRelation: async (ctx, next) => {
    return strapi.services.modelpesawat.addRelation(ctx.params, ctx.request.body);
  },

  /**
   * Update relation to a/an modelpesawat record.
   *
   * @return {Object}
   */

  updateRelation: async (ctx, next) => {
    return strapi.services.modelpesawat.editRelation(ctx.params, ctx.request.body);
  },

  /**
   * Destroy relation to a/an modelpesawat record.
   *
   * @return {Object}
   */

  destroyRelation: async (ctx, next) => {
    return strapi.services.modelpesawat.removeRelation(ctx.params, ctx.request.body);
  }
};
