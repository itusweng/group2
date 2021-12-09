import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/admin',
      redirect: '/trainings',
      component: () => import('@/view/layout/Layout'),
      children: [
        {
          path: 'trainings',
          component: () => import('@/view/pages/admin/trainings'),
          children: [
            {
              path: 'list',
              component: () => import('@/view/pages/admin/trainings/TrainingList'),
            },
            {
              path: 'create',
              component: () => import('@/view/pages/admin/trainings/CreateTraining'),
            }
          ]
        }
      ]
    },
    {
      path: '/',
      redirect: '/dashboard',
      component: () => import('@/view/layout/Layout'),
      children: [
        {
          path: '/dashboard',
          name: 'dashboard',
          component: () => import('@/view/pages/Dashboard.vue')
        },
        {
          path: '/trainings/:id',
          component: () => import('@/view/pages/trainings/TrainingDetails')
        },
        {
          path: '/lessons/:id',
          component: () => import('@/view/pages/trainings/LessonDetails')
        },
        {
          path: '/builder',
          name: 'builder',
          component: () => import('@/view/pages/Builder.vue')
        },
        {
          path: '/vue-bootstrap',
          name: 'vue-bootstrap',
          component: () =>
            import('@/view/pages/vue-bootstrap/VueBootstrap.vue'),
          children: [
            {
              path: 'alert',
              name: 'vue-bootstrap-alert',
              component: () => import('@/view/pages/vue-bootstrap/Alert.vue')
            },
            {
              path: 'badge',
              name: 'vue-bootstrap-badge',
              component: () => import('@/view/pages/vue-bootstrap/Badge.vue')
            },
            {
              path: 'button',
              name: 'vue-bootstrap-button',
              component: () => import('@/view/pages/vue-bootstrap/Button.vue')
            },
            {
              path: 'button-group',
              name: 'vue-bootstrap-button-group',
              component: () =>
                import('@/view/pages/vue-bootstrap/ButtonGroup.vue')
            },
            {
              path: 'button-toolbar',
              name: 'vue-bootstrap-button-toolbar',
              component: () =>
                import('@/view/pages/vue-bootstrap/ButtonToolbar.vue')
            },
            {
              path: 'card',
              name: 'vue-bootstrap-card',
              component: () => import('@/view/pages/vue-bootstrap/Card.vue')
            },
            {
              path: 'carousel',
              name: 'vue-bootstrap-carousel',
              component: () => import('@/view/pages/vue-bootstrap/Carousel.vue')
            },
            {
              path: 'collapse',
              name: 'vue-bootstrap-collapse',
              component: () => import('@/view/pages/vue-bootstrap/Collapse.vue')
            },
            {
              path: 'dropdown',
              name: 'vue-bootstrap-dropdown',
              component: () => import('@/view/pages/vue-bootstrap/Dropdown.vue')
            },
            {
              path: 'embed',
              name: 'vue-bootstrap-embed',
              component: () => import('@/view/pages/vue-bootstrap/Embed.vue')
            },
            {
              path: 'form',
              name: 'vue-bootstrap-form',
              component: () => import('@/view/pages/vue-bootstrap/Form.vue')
            },
            {
              path: 'form-checkbox',
              name: 'vue-bootstrap-form-checkbox',
              component: () =>
                import('@/view/pages/vue-bootstrap/FormCheckbox.vue')
            },
            {
              path: 'form-file',
              name: 'vue-bootstrap-form-file',
              component: () => import('@/view/pages/vue-bootstrap/FormFile.vue')
            },
            {
              path: 'form-group',
              name: 'vue-bootstrap-form-group',
              component: () =>
                import('@/view/pages/vue-bootstrap/FormGroup.vue')
            },
            {
              path: 'form-input',
              name: 'vue-bootstrap-form-input',
              component: () =>
                import('@/view/pages/vue-bootstrap/FormInput.vue')
            },
            {
              path: 'form-radio',
              name: 'vue-bootstrap-form-radio',
              component: () =>
                import('@/view/pages/vue-bootstrap/FormRadio.vue')
            },
            {
              path: 'form-select',
              name: 'vue-bootstrap-form-select',
              component: () =>
                import('@/view/pages/vue-bootstrap/FormSelect.vue')
            },
            {
              path: 'form-textarea',
              name: 'vue-bootstrap-form-textarea',
              component: () =>
                import('@/view/pages/vue-bootstrap/FormTextarea.vue')
            },
            {
              path: 'image',
              name: 'vue-bootstrap-image',
              component: () => import('@/view/pages/vue-bootstrap/Image.vue')
            },
            {
              path: 'input-group',
              name: 'vue-bootstrap-input-group',
              component: () =>
                import('@/view/pages/vue-bootstrap/InputGroup.vue')
            },
            {
              path: 'jumbotron',
              name: 'vue-bootstrap-jumbotron',
              component: () =>
                import('@/view/pages/vue-bootstrap/Jumbotron.vue')
            },
            {
              path: 'layout-grid-system',
              name: 'vue-bootstrap-layout-grid-system',
              component: () =>
                import('@/view/pages/vue-bootstrap/LayoutGridSystem.vue')
            },
            {
              path: 'link',
              name: 'vue-bootstrap-link',
              component: () => import('@/view/pages/vue-bootstrap/Link.vue')
            },
            {
              path: 'list-group',
              name: 'vue-bootstrap-list-group',
              component: () =>
                import('@/view/pages/vue-bootstrap/ListGroup.vue')
            },
            {
              path: 'media',
              name: 'vue-bootstrap-media',
              component: () => import('@/view/pages/vue-bootstrap/Media.vue')
            },
            {
              path: 'modal',
              name: 'vue-bootstrap-modal',
              component: () => import('@/view/pages/vue-bootstrap/Modal.vue')
            },
            {
              path: 'nav',
              name: 'vue-bootstrap-nav',
              component: () => import('@/view/pages/vue-bootstrap/Nav.vue')
            },
            {
              path: 'navbar',
              name: 'vue-bootstrap-navbar',
              component: () => import('@/view/pages/vue-bootstrap/Navbar.vue')
            },
            {
              path: 'pagination',
              name: 'vue-bootstrap-pagination',
              component: () =>
                import('@/view/pages/vue-bootstrap/Pagination.vue')
            },
            {
              path: 'pagination-nav',
              name: 'vue-bootstrap-pagination-nav',
              component: () =>
                import('@/view/pages/vue-bootstrap/PaginationNav.vue')
            },
            {
              path: 'notify-popover',
              name: 'vue-bootstrap-popover',
              component: () => import('@/view/pages/vue-bootstrap/Popover.vue')
            },
            {
              path: 'notify-toasts',
              name: 'vue-bootstrap-toasts',
              component: () => import('@/view/pages/vue-bootstrap/Toasts.vue')
            },
            {
              path: 'notify-tooltip',
              name: 'vue-bootstrap-tooltip',
              component: () => import('@/view/pages/vue-bootstrap/Tooltip.vue')
            },
            {
              path: 'progress',
              name: 'vue-bootstrap-progress',
              component: () => import('@/view/pages/vue-bootstrap/Progress.vue')
            },
            {
              path: 'progress-spinner',
              name: 'vue-bootstrap-spinner',
              component: () => import('@/view/pages/vue-bootstrap/Spinner.vue')
            },
            {
              path: 'table',
              name: 'vue-bootstrap-table',
              component: () => import('@/view/pages/vue-bootstrap/Table.vue')
            },
            {
              path: 'tabs',
              name: 'vue-bootstrap-tabs',
              component: () => import('@/view/pages/vue-bootstrap/Tabs.vue')
            }
          ]
        },
        {
          path: '/custom-wizard',
          name: 'wizard',
          component: () => import('@/view/pages/wizard/Wizard.vue'),
          children: [
            {
              path: 'wizard-1',
              name: 'wizard-1',
              component: () => import('@/view/pages/wizard/Wizard-1.vue')
            },
            {
              path: 'wizard-2',
              name: 'wizard-2',
              component: () => import('@/view/pages/wizard/Wizard-2.vue')
            },
            {
              path: 'wizard-3',
              name: 'wizard-3',
              component: () => import('@/view/pages/wizard/Wizard-3.vue')
            },
            {
              path: 'wizard-4',
              name: 'wizard-4',
              component: () => import('@/view/pages/wizard/Wizard-4.vue')
            }
          ]
        },
        {
          path: '/custom-plugins',
          name: 'plugins',
          component: () => import('@/view/pages/plugins/Plugins.vue'),
          children: [
            {
              path: 'cropper',
              name: 'cropper',
              component: () => import('@/view/pages/plugins/Cropper.vue')
            },
            {
              path: 'treeselect',
              name: 'treeselect',
              component: () => import('@/view/pages/plugins/Treeselect.vue')
            }
          ]
        },
        {
          path: '/profile',
          name: 'profile',
          component: () => import('@/view/pages/profile/Profile.vue'),
          children: [
            {
              path: 'profile-1',
              name: 'profile-1',
              component: () => import('@/view/pages/profile/Profile-1.vue')
            },
            {
              path: 'profile-2',
              name: 'profile-2',
              component: () => import('@/view/pages/profile/Profile-2.vue')
            },
            {
              path: 'profile-3',
              name: 'profile-3',
              component: () => import('@/view/pages/profile/Profile-3.vue')
            },
            {
              path: 'profile-4',
              name: 'profile-4',
              component: () => import('@/view/pages/profile/Profile-4.vue')
            }
          ]
        }
      ]
    },

    {
      path: '/custom-error',
      name: 'error',
      component: () => import('@/view/pages/error/Error.vue'),
      children: [
        {
          path: 'error-1',
          name: 'error-1',
          component: () => import('@/view/pages/error/Error-1.vue')
        },
        {
          path: 'error-2',
          name: 'error-2',
          component: () => import('@/view/pages/error/Error-2.vue')
        },
        {
          path: 'error-3',
          name: 'error-3',
          component: () => import('@/view/pages/error/Error-3.vue')
        },
        {
          path: 'error-4',
          name: 'error-4',
          component: () => import('@/view/pages/error/Error-4.vue')
        },
        {
          path: 'error-5',
          name: 'error-5',
          component: () => import('@/view/pages/error/Error-5.vue')
        },
        {
          path: 'error-6',
          name: 'error-6',
          component: () => import('@/view/pages/error/Error-6.vue')
        }
      ]
    },
    {
      path: '/',
      component: () => import('@/view/pages/auth/Auth'),
      children: [
        {
          name: 'login',
          path: '/login',
          component: () => import('@/view/pages/auth/Auth')
        }
      ]
    },
    {
      path: '*',
      redirect: '/404'
    },
    {
      // the 404 route, when none of the above matches
      path: '/404',
      name: '404',
      component: () => import('@/view/pages/error/Error-1.vue')
    }
  ]
});
