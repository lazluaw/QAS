<template>
    <div class="sidebar-wrapper">
        <nav
                :class="{sidebar: true, sidebarStatic, sidebarOpened}"
                @mouseenter="sidebarMouseEnter"
                @mouseleave="sidebarMouseLeave">
            <header class="logo">
                <router-link to="/main"><span class="primary-word">QAS</span></router-link>
            </header>
            <ul class="nav">
                <NavLink
                        :activeItem="activeItem"
                        header="My QAS"
                        link="/main"
                        iconName="flaticon-home"
                        index="main"
                        isHeader
                />
                <NavLink
                        :activeItem="activeItem"
                        header="HashTag"
                        link="/hashtag"
                        iconName="flaticon-network"
                        index="hashtag"
                        isHeader
                />
                <NavLink
                        :activeItem="activeItem"
                        header="Stars"
                        link="/stars"
                        iconName="flaticon-star"
                        index="stars"
                        isHeader
                />
            </ul>
            <!--
                    <NavLink
                        :activeItem="activeItem"
                        header="보류"
                        link="/notifications"
                        iconName="flaticon-equal-1"
                        index="notifications"
                        isHeader
                    />
                    <NavLink
                        :activeItem="activeItem"
                        header="보류"
                        link="/components"
                        iconName="flaticon-list"
                        index="components"
                        :childrenLinks="[
                          { header: 'Charts', link: '/components/charts' },
                          { header: 'Icons', link: '/components/icons' },
                          { header: 'Maps', link: '/components/maps' },
                        ]"
                    />
            -->
            <!-- 라벨 메뉴
            <p>
            <h5 class="navTitle">
              LABELS
              <a class="actionLink">
                <i class="la la-plus float-right"/>
              </a>
            </h5>
            <ul class="sidebarLabels">
              <li>
                <a href="#">
                  <i class="fa fa-circle text-danger mr-2"/>
                  <span class="labelName">My Recent</span>
                </a>
              </li>
              <li>
                <a href="#">
                  <i class="fa fa-circle text-primary mr-2"/>
                  <span class="labelName">Starred</span>
                </a>
              </li>
              <li>
                <a href="#">
                  <i class="fa fa-circle mr-2"/>
                  <span class="labelName">Background</span>
                </a>
              </li>
            </ul> -->
            <!-- 프로젝트 메뉴
            <h5 class="navTitle">
              PROJECTS
            </h5>
            <div class="sidebarAlerts">
              <b-alert
                  v-for="alert in alerts"
                  :key="alert.id"
                  class="sidebarAlert" variant="transparent"
                  show dismissible
              >
                <span>{{alert.title}}</span><br/>
                <b-progress class="sidebarProgress progress-xs mt-1"
                            :variant="alert.color" :value="alert.value" :max="100"/>
                <small>{{alert.footer}}</small>
              </b-alert>
            </div> -->
        </nav>
    </div>
</template>

<script>
    import {mapState, mapActions} from 'vuex';
    import isScreen from '@/core/screenHelper';
    import NavLink from './NavLink/NavLink';

    export default {
        name: 'Sidebar',
        components: {NavLink},
        data() {
            return {
                alerts: [
                    {
                        id: 0,
                        title: 'Sales Report',
                        value: 15,
                        footer: 'Calculating x-axis bias... 65%',
                        color: 'danger',
                    },
                    {
                        id: 1,
                        title: 'Personal Responsibility',
                        value: 20,
                        footer: 'Provide required notes',
                        color: 'primary',
                    },
                ],
            };
        },
        methods: {
            ...mapActions('layout', ['changeSidebarActive', 'switchSidebar']),
            setActiveByRoute() {
                const paths = this.$route.fullPath.split('/');
                paths.pop();
                this.changeSidebarActive(paths.join('/'));
            },
            sidebarMouseEnter() {
                if (!this.sidebarStatic && (isScreen('lg') || isScreen('xl'))) {
                    this.switchSidebar(false);
                    this.setActiveByRoute();
                }
            },
            sidebarMouseLeave() {
                if (!this.sidebarStatic && (isScreen('lg') || isScreen('xl'))) {
                    this.switchSidebar(true);
                    this.changeSidebarActive(null);
                }
            },
        },
        created() {
            this.setActiveByRoute();
        },
        computed: {
            ...mapState('layout', {
                sidebarStatic: state => state.sidebarStatic,
                sidebarOpened: state => !state.sidebarClose,
                activeItem: state => state.sidebarActiveElement,
            }),
        },
    };
</script>

<!-- Sidebar styles should be scoped -->
<style src="./Sidebar.scss" lang="scss" scoped/>
